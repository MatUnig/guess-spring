package unig.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // -- fields
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    // -- constructors

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // -- public methods
    @Override
    public int next() {
        return random.ints(1,minNumber,maxNumber+1).findFirst().getAsInt();
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
