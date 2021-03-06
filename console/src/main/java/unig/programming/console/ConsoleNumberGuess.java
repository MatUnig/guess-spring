package unig.programming.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import unig.programming.Game;
import unig.programming.MessageGenerator;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == constructors
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == events
    @EventListener(ContextRefreshedEvent.class)
    public void start () {
        log.info("start() -- > Container ready to use.");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon()|| game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? y/n");

                String playAgain =scanner.nextLine();
                if (!playAgain.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();

            }
        }
    }
}
