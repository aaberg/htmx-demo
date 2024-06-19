package aaberg.htmx_demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class Examples {

    private final Random random = new Random();

    @GetMapping("randomnumber")
    public String randomNumber(Model model) {

        model.addAttribute("randomNumber", random.nextInt());
        return "examples/randomnumber";
    }

    @GetMapping("counter")
    public String counter(Model model, int value) {
        model.addAttribute("counter", value);
        return "examples/counter";
    }
}
