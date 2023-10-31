package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;

public class ParseStringToFruitTransaction implements Parser{
    @Override
    public FruitTransaction parse(String line) {
        String[] splitedLine = line.split(",");
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(splitedLine[0])) {
                return new FruitTransaction(operation,splitedLine[1],Integer.parseInt(splitedLine[2]));
            }
        }
        throw new RuntimeException("can't parse this line");
    }
}
