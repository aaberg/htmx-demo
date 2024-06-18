package aaberg.htmx_demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/slides")
public class Slides {

    @GetMapping("/{slide}")
    public String present(@RequestHeader(value = "Hx-Request", required = false) boolean hxRequest,
                          @PathVariable("slide") String slide,
                          Model model) {

        final var tempate = "/slides/" + slide;

        if (hxRequest) {
            return tempate;
        } else {
            model.addAttribute("slide", tempate);
            return "index";
        }
    }
}
