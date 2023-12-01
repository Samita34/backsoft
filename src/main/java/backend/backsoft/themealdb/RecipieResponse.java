package backend.backsoft.themealdb;

import java.util.List;

import backend.backsoft.dto.Recipie;

public class RecipieResponse {
    private List<Recipie> meals;

    // Getters y setters
    public List<Recipie> getMeals() {
        return meals;
    }

    public void setMeals(List<Recipie> meals) {
        this.meals = meals;
    }
    
}
