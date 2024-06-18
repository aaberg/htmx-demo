package aaberg.htmx_demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("slide", "/slides/slide1");

        return "index";
    }
}
