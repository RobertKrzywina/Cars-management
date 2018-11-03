package controller.MVC_controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarSortController {

    private CarRepository carRepo;
    private List<Car> cars;

    @Autowired
    public CarSortController(CarRepository carRepo) {
        this.carRepo = carRepo;
        cars = new ArrayList<>();
    }

    @GetMapping("/sortById")
    public String sortById(Model model) {
        cars = carRepo.findAllByOrderByIdAsc();
        model.addAttribute("cars", cars);
        return "show";
    }

    @GetMapping("/sortByBrand")
    public String sortByBrand(Model model) {
        cars = carRepo.findAllByOrderByBrandAsc();
        model.addAttribute("cars", cars);
        return "show";
    }

    @GetMapping("/sortByYearAsc")
    public String sortByYearASC(Model model) {
        cars = carRepo.findAllByOrderByYearAsc();
        model.addAttribute("cars", cars);
        return "show";
    }

    @GetMapping("/sortByYearDesc")
    public String sortByYearDESC(Model model) {
        cars = carRepo.findAllByOrderByYearDesc();
        model.addAttribute("cars", cars);
        return "show";
    }

    @GetMapping("/sortByPriceAsc")
    public String sortByPriceASC(Model model) {
        cars = carRepo.findAllByOrderByPriceAsc();
        model.addAttribute("cars", cars);
        return "show";
    }

    @GetMapping("/sortByPriceDesc")
    public String sortByPriceDESC(Model model) {
        cars = carRepo.findAllByOrderByPriceDesc();
        model.addAttribute("cars", cars);
        return "show";
    }
}
