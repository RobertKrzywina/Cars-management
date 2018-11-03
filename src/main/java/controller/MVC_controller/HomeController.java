package controller.MVC_controller;

import model.Address;
import model.Car;
import model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("newCar", new Car());
        model.addAttribute("carOwner", new Owner());
        model.addAttribute("ownerAddress", new Address());
        return "index";
    }
}
