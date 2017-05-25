package base.catalogDb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private CatalogRepository catalogRepository;

    public DbSeeder(CatalogRepository repository) {
        catalogRepository = repository;
    }

    @Override
    public void run(String ... strings) throws Exception {
        //This code is run every time the project is deployed, locally or on heroku.
        //If you want to use this to seed, be aware that it will permanently affect the database.
    }

}
