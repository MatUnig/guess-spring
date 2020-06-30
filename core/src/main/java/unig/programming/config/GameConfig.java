package unig.programming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import unig.programming.GuessCount;
import unig.programming.MaxNumber;
import unig.programming.MinNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages="unig.programming")
public class GameConfig {

    // == fields
    //defining default value if not found in properties
    @Value("${game.maxNumber:100}")
    private int maxNumber;
    @Value("${game.guessCount:10}")
    private int guessCount;
    @Value("${game.minNumber:0}")
    private int minNumber;

    // == bean methods
    @MaxNumber
    @Bean
    public int maxNumber(){
        return maxNumber;
    }

    @GuessCount
    @Bean
    public int guessCount(){
        return guessCount;
    }

    @MinNumber
    @Bean
    public int minNumber(){
        return minNumber;
    }

}
