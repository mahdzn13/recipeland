package com.recipeland;

import com.recipeland.pojo.Ingredient;
import com.recipeland.pojo.User;
import com.recipeland.repository.IngredientRepository;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import com.recipeland.pojo.Recipe;


@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(
            RecipeRepository recipeRepository,
            UserRepository userRepository,
            IngredientRepository ingredientRepository) {
        return args -> {

            // ** WARNING ** \\
            //Delete all nodes from the DB.
            /*
            recipeRepository.deleteAll();
            userRepository.deleteAll();
            ingredientRepository.deleteAll();
            */

            //Creation of the data
            Recipe volcano = new Recipe("Volcano");
            Recipe lasagna = new Recipe("Lasagna");
            Recipe bacalao = new Recipe("Bacalao al pin pin");

            User marco = new User("mahernandezd","Marco","marco@recipeland.com");
            User joshua = new User("jgarcias","Joshua","joshua@recipeland.com");
            User jose = new User("jjimenez","Jose","jose@recipeland.com");

            Ingredient manzana = new Ingredient("Manzana");
            Ingredient pepinillo = new Ingredient("Pepinillo");
            Ingredient lomo = new Ingredient("Lomo");

            //Creation of nodes using the data
            recipeRepository.save(volcano);
            recipeRepository.save(lasagna);
            recipeRepository.save(bacalao);

            userRepository.save(marco);
            userRepository.save(joshua);
            userRepository.save(jose);

            ingredientRepository.save(manzana);
            ingredientRepository.save(pepinillo);
            ingredientRepository.save(lomo);

        };
    }
}