package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("application.repository")
@EntityScan("application.models")
public class Runner
{
    public static void main(String[] args)
    {
        SpringApplication.run(Runner.class);
    }
}