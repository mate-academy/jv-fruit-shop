package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserServiceImpl implements ParserService {
    private final int OPERATION_INDEX = 0;
    private final int FRUIT_NAME_INDEX = 1;
    private final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String string : data) {
            String[] splittedData = string.split(",");
            Optional<FruitTransaction.Operation> operationName =
                    FruitTransaction.Operation.get(splittedData[OPERATION_INDEX]);
            FruitTransaction fruit = new FruitTransaction(operationName.get(),
                    splittedData[FRUIT_NAME_INDEX],
                    Integer.parseInt(splittedData[FRUIT_QUANTITY_INDEX]));
            fruitTransactions.add(fruit);
        }
        return fruitTransactions;
    }
}
