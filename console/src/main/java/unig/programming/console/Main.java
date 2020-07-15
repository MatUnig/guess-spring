package unig.programming.console;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import unig.programming.config.GameConfig;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess The Number Game");



        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // get number generator bean from context (container)
     //   NumberGenerator numberGenerator
     //           = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
       // int number = numberGenerator.next();


        // log generated number
     //   log.info("number = {}", number);

        // get message generator bean from context (container)
//        MessageGenerator messageGenerator =
//                context.getBean(MessageGenerator.class);
//        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
//        log.info("getResultMessage= {}", messageGenerator.getResultMessage());

        // close context (container)
        context.close();


    }
}