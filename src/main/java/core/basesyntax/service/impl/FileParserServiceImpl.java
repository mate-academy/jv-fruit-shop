package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;
import java.util.ArrayList;
import java.util.List;

public class FileParserServiceImpl implements FileParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String RECORD_DIVIDER = ",";

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> fruitsDataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String fruitDataFromFile : fruitsDataFromFile) {
            FruitTransaction fruitData = new FruitTransaction();
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getOperation()
                        .equals(fruitDataFromFile.split(RECORD_DIVIDER)[OPERATION_INDEX])) {
                    fruitData.setOperation(operation);
                }
            }
            fruitData.setFruit(fruitDataFromFile.split(RECORD_DIVIDER)[FRUIT_NAME_INDEX]);
            fruitData.setQuantity(Integer
                    .parseInt(fruitDataFromFile.split(RECORD_DIVIDER)[QUANTITY_INDEX]));
            fruitTransactions.add(fruitData);
        }
        return fruitTransactions;
    }
}
