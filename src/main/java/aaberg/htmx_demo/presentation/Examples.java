package aaberg.htmx_demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("signup")
    public String signup(Model model, String email, String firstName, String lastName) {

            model.addAttribute("email", email);
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);

            return "examples/signup";
    }

    @PostMapping("signup/email-validation")
    public String signupEmailValidation(Model model, String email) {

        var error = "";
        if (!(email.contains("@") && email.contains("."))) {
            error = "Invalid email address";
        } else if ("test@test.com".equals(email)) {
            error = "Email address already in use";
        }
        final var isError = StringUtils.hasText(error);

        model.addAttribute("email", email);
        model.addAttribute("error", error);
        model.addAttribute("isError", isError);

        return "examples/signup-email-validation";
    }
}
