package backend.backsoft.dto;

public class Recipie {
private String idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String[] strIngredients = new String[20];
    private String[] strMeasures = new String[20];
    // Otros campos como strSource, strImageSource, etc., si son necesarios

    // Constructor, getters y setters
    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }
}
