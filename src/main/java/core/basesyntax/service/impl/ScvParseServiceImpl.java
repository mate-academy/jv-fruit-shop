package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ScvParseServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fileContent) {
        return fileContent.stream()
                .skip(1)
                .map(str -> {
                    String[] fruitInfo = str.split(",");
                    String operation = fruitInfo[OPERATION_INDEX];
                    String fruitName = fruitInfo[NAME_INDEX];
                    int amount = Integer.parseInt(fruitInfo[AMOUNT_INDEX]);
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction
                            .Operation.findOperation(operation));
                    fruitTransaction.setFruit(fruitName);
                    fruitTransaction.setQuantity(amount);
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
