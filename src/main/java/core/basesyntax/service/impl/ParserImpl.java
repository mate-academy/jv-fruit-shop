package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    public static final ValidatorImpl validatorImpl = new ValidatorImpl();
    
    @Override
    public TransactionDto parseLine(String line) {
        if (validatorImpl.validateLine(line)) {
            String[] fruitData = line.split(",");
            return new TransactionDto(fruitData[0], fruitData[1], Integer.parseInt(fruitData[2]));
        }
        return null;
    }
}
