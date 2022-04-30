package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;

public class ParserServiceImpl implements ParserService {
    @Override
    public FruitTransaction parse(String lineFromFile) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] transactionData = lineFromFile.split(",");
        fruitTransaction.setOperation(Arrays.stream(FruitTransaction.OperationType.values())
                .filter(type -> type.getOperationType().equals(transactionData[0]))
                .findFirst()
                .orElse(null));
        fruitTransaction.setFruitName(transactionData[1]);
        fruitTransaction.setQuantity(Integer.parseInt(transactionData[2]));
        return fruitTransaction;
    }
}
