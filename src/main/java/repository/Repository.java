package repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Address;
import model.Car;
import model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Repository {

    @NonNull
    private CarRepository carRepo;
    @NonNull
    private OwnerRepository ownerRepo;
    @NonNull
    private AddressRepository addressRepo;

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
