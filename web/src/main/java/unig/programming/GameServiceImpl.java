package unig.programming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    // == Fields ==
    public final Game game;

    public final MessageGenerator messageGenerator;

    public String name;
    // == Constructors ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    // == Init ==
    @PostConstruct
    public void init(){
        log.info(messageGenerator.getMainMessage() + game.getNumber());
    }
    // == Public methods ==
    @Override
    public boolean isGameOver() {
        if (game.isGameLost()) {
            return false;
        }
        else return true;
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();

    }
}
