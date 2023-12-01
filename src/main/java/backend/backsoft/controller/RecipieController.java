package backend.backsoft.controller;

import org.springframework.web.bind.annotation.*;

import backend.backsoft.service.MealService;
import backend.backsoft.themealdb.RecipieResponse;


@RestController
@RequestMapping("/meals")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class RecipieController {

    private final MealService mealService;

    public RecipieController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/{recipieName}")
    public RecipieResponse getRecipie(@PathVariable String recipieName) {
        return mealService.getRecipieByName(recipieName);
    }

    // Puedes agregar más métodos para otros endpoints si es necesario
}
