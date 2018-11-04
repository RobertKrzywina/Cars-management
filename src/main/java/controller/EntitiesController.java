package controller;

import model.Address;
import model.Car;
import model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.Repository;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class EntitiesController {

    private Repository repository;

    @Autowired
    public EntitiesController(Repository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car,
                         @ModelAttribute Owner owner,
                         @ModelAttribute Address address,
                         Model model) {
        repository.save(car, owner, address);
        model.addAttribute("message", "Added.");
        return "success";
    }

    @GetMapping
    public String showCars(Model model) {
        List<Car> cars = repository.getCars();
        model.addAttribute("cars", cars);
        return "show";
    }

    @DeleteMapping("/delete")
    public String deleteCar(@RequestParam Long id,
                            Model model) {
        repository.deleteCar(id);
        model.addAttribute("message", "Deleted.");
        return "success";
    }
}
