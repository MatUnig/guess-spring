package unig.programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == Constants
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == init
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    // == Fields
    private final Game game;

    // == Constructors

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == Methods
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
        }   else if (!game.isValidNumber()){
            return "Invalid number range.";
        }   else if (game.getGuessCount()==game.getRemainingGuesses()){
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
