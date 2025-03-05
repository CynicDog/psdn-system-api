package kr.co.metlife.pseudomgtsystemapi;

import kr.co.metlife.pseudomgtsystemapi.store.repository.ParameterRepository;
import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PseudomgtSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PseudomgtSystemApiApplication.class, args);
    }
}
