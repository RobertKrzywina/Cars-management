package controller.REST_controller;

import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.AddressRepository;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressRepository addressRepo;

    @Autowired
    public AddressController(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> getAddresses() {
        return addressRepo.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}")
    public Address getAddress(@PathVariable Long id) {
        return addressRepo.findById(id).orElse(null);
    }
}
