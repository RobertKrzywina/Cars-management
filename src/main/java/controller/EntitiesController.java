package controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Address;
import model.Car;
import model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import repository.Repository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class EntitiesController {

    @NonNull
    private Repository repository;

    @PostMapping("/add")
    public String addCar(@Valid @ModelAttribute Car car,
                         @Valid @ModelAttribute Owner owner,
                         @Valid @ModelAttribute Address address,
                         Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "error";
        }
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
