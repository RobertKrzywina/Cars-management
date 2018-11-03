package controller.REST_controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarRepository carRepo;

    @Autowired
    public CarController(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getCars() {
        return carRepo.findAllCarsWithoutOwner();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                path = "/{id}")
    public Car getCar(@PathVariable Long id) {
        return carRepo.findById(id).orElse(null);
    }
}
