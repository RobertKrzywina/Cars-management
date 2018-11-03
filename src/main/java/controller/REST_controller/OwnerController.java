package controller.REST_controller;

import model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.OwnerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private OwnerRepository ownerRepo;

    @Autowired
    public OwnerController(OwnerRepository ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}")
    public Owner getOwner(@PathVariable Long id) {
        return ownerRepo.findById(id).orElse(null);
    }
}
