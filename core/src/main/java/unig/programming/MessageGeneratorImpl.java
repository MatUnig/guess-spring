package unig.programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("messageGenerator")
public class MessageGeneratorImpl implements MessageGenerator {

    // -- Constants
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // -- init
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    // -- Fields
    @Autowired
    private Game game;
    private int guessCount=10;

    // -- Methods
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it ?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()){
            return "You guessed it. Number was: " + game.getNumber();
        }   else if (game.isGameLost()){
            return "You lost. Number was: "+ game.getNumber();
        }   else if (game.isValidNumber()){
            return "Invalid number range.";
        }   else if (game.getRemainingGuesses()==guessCount){
            return "What is your first guess?";
        }   else{
            String direction = "Lower!";
            if (game.getGuess() <game.getNumber()){
                direction = "Higher!";
            }
            return direction + "! You have remaining chances: " + game.getRemainingGuesses();
        }
    }
}
