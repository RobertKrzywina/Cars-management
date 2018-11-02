package repository;

import model.Address;
import model.Car;
import model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Repository {

    private CarRepository carRepo;
    private OwnerRepository ownerRepo;
    private AddressRepository addressRepo;

    @Autowired
    public Repository(CarRepository carRepo, OwnerRepository ownerRepo, AddressRepository addressRepo) {
        this.carRepo = carRepo;
        this.ownerRepo = ownerRepo;
        this.addressRepo = addressRepo;
    }

    public void save(Car car, Owner owner, Address address) {
        addressRepo.save(address);
        owner.setAddress(address);
        ownerRepo.save(owner);
        car.setOwner(owner);
        carRepo.save(car);
    }

    public List<Car> getCars() {
        return carRepo.findAll();
    }

    public void deleteCar(Long id) {
        if (findCar(id) != null) {
            carRepo.deleteById(id);
            ownerRepo.deleteById(id);
            addressRepo.deleteById(id);
        }
    }

    private Car findCar(Long id) {
        return carRepo.findById(id).orElse(null);
    }
}
