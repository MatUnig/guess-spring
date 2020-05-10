package unig.programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        //creating context(container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        //getting bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        log.info("number = {}", number);

        Game game = context.getBean(Game.class);

        game.reset();
        context.close();
    }
}
