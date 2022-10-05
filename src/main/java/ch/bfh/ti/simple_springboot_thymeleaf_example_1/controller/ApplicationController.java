package ch.bfh.ti.simple_springboot_thymeleaf_example_1.controller;

import ch.bfh.ti.simple_springboot_thymeleaf_example_1.PersonContainer;
import ch.bfh.ti.simple_springboot_thymeleaf_example_1.entity.AboutUs;
import ch.bfh.ti.simple_springboot_thymeleaf_example_1.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class ApplicationController {


    private final PersonContainer personContainer;

    public ApplicationController(PersonContainer personContainer) {
        this.personContainer = personContainer;
    }


    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<AboutUs> aboutUses = List.of(
                new AboutUs("lorem ipsum","Lorem ipsum dolor sit amet consectetur adipisicing elit."),
                new AboutUs("lorem ipsum","Lorem ipsum dolor sit amet consectetur adipisicing elit."),
                new AboutUs("lorem ipsum","Lorem ipsum dolor sit amet consectetur adipisicing elit.")
        );
        model.addAttribute("aboutUses", aboutUses);
        log.info("ApplicationController::index()");
        return "index";
    }

    @RequestMapping(path = "/about", method = RequestMethod.GET)
    public String about() {
        log.info("ApplicationController::about()");
        return "about";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        log.info("ApplicationController::contact()");
        List<Person> persons = personContainer.getPersons();
        model.addAttribute("persons",persons);
        model.addAttribute("person",new Person());
        return "contact";
    }





    @RequestMapping(path = "/createPerson",method = RequestMethod.POST)
    public  String createPerson(Person person,Model model){
        List<Person> persons = personContainer.getPersons();
        if(!person.getFirstName().equals("") && !person.getLastName().equals("")) {
            persons.add(person);
        }
        model.addAttribute("persons",persons);
        model.addAttribute("person",new Person());
        return  "contact";
    }

}
