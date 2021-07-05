package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import java.util.Arrays;

public class ParserImpl implements Parser {
    @Override
    public Transaction parseLine(String line) {
        String[] splittedLine = line.split(",");
        isValid(splittedLine);
        return new Transaction(splittedLine[0],
                new Fruit(splittedLine[1]),
                Integer.parseInt(splittedLine[2]));
    }

    private void isValid(String[] value) {
        if (value.length != 3 || Integer.parseInt(value[2]) <= 0) {
            throw new RuntimeException("Data is not valid" + Arrays.toString(value));
        }
    }
}
