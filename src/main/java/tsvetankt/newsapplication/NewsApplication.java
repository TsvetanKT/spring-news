package tsvetankt.newsapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("tsvetankt.newsapplication")
public class NewsApplication {
    
    private final Logger LOG = LoggerFactory.getLogger(NewsApplication.class);

    public static void main(String[] args) {
        System.out.println("start");
        SpringApplication.run(NewsApplication.class, args);
    }
    
    @Bean
    CommandLineRunner initDatabase(final DataInitializer initializer) {
        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                LOG.info("\n +++++++++ Initializing Test Data +++++++++ ");
                initializer.initData();
            }
        };
    }
}
