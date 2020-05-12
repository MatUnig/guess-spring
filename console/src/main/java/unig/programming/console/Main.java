package unig.programming.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import unig.programming.AppConfig;
import unig.programming.MessageGenerator;
import unig.programming.NumberGenerator;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        //creating context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //getting bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        //using methods from beans

        int number = numberGenerator.next();
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        String generated = messageGenerator.getMainMessage();
        String result = messageGenerator.getResultMessage();

        log.info("Main message = {}", generated + result);
        log.info("number = {}", number);

        //Game game = context.getBean(Game.class);


        context.close();
    }
}
