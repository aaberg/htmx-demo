package aaberg.htmx_demo.presentation;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Search {

    private final List<SearchItem> searchItems = new ArrayList<>();
    private final Faker faker = new Faker();

    public Search() {
        for (int i = 0; i < 100; i++) {
            searchItems.add(new SearchItem(
                    faker.idNumber().valid(),
                    faker.funnyName().name(),
                    faker.beer().name()
            ));
        }
    }

    @GetMapping("search")
    public String doSearch(Model model, String query) throws InterruptedException {

        Thread.sleep(1000);

        final var lowercaseQuery = query != null ? query.toLowerCase() : "";
        final var results = StringUtils.hasText(query) ? searchItems.stream()
                .filter(item -> item.name().toLowerCase().contains(lowercaseQuery) || item.favoriteBeer().toLowerCase().contains(lowercaseQuery))
                .toList() : List.of();
        model.addAttribute("results", results);

        return "search/search";
    }

    private record SearchItem(String id, String name, String favoriteBeer){}
}
