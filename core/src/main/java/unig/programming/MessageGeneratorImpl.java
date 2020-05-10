package unig.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageGenerator")
public class MessageGeneratorImpl implements MessageGenerator {

    // -- Fields
    @Autowired
    private Game game;
    private int guessCount=10;


    @Override
    public String getMainMessage() {
        return "Hi";
    }

    @Override
    public String getResultMessage() {
        return "Bye";
    }
}
