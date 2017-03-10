package com.esliceu.dwes.marco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import com.esliceu.dwes.marco.pojo.Recipe;
import com.esliceu.dwes.marco.repository.RecipeRepository;


@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(RecipeRepository recipeRepository) {
        return args -> {

            //Deletes all
            //recipeRepository.deleteAll();

            //Creation of pojos
            Recipe volcano = new Recipe("Volcano");
            Recipe lasagna = new Recipe("Lasagna");
            Recipe bacalao = new Recipe("Bacalao al pin pin");



            //Creation of node
            recipeRepository.save(volcano);
            recipeRepository.save(lasagna);
            recipeRepository.save(bacalao);


        };
    }
}