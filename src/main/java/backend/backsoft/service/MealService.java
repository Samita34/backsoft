package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import backend.backsoft.themealdb.RecipieResponse;

@Service
public class MealService {
      private final String apiUrl = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Autowired
    private RestTemplate restTemplate;

    public RecipieResponse getRecipieByName(String recipieName) {
        String url = apiUrl + recipieName;
        return restTemplate.getForObject(url, RecipieResponse.class);
    }
}