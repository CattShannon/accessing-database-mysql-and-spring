package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo") //El request mapping asigna por defecto todas las operaciones HTTP
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Mapea solo el POST request
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody el String retornado es una respuesta, no el nombre de una vista
        // @RequestParam es un parametro de la peticion GET o POST

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}
