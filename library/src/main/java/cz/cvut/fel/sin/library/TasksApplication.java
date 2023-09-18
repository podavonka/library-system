package cz.cvut.fel.sin.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableCaching
@EnableScheduling
public class TasksApplication {

    // sudo service postgresql start
    // mvn liquibase:generateChangeLog
	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}
