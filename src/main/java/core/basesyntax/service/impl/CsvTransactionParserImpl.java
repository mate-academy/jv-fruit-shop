package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitOperation> parseDataFile(List<String> data) {
        List<FruitOperation> fruitOperations = new ArrayList<>();
        for (String line : data.subList(1, data.size())) {
            FruitOperation fruitOperation = new FruitOperation();
            String[] splitLine = line.split(SEPARATOR);
            String letter = splitLine[OPERATION_INDEX];
            String nameFruit = splitLine[NAME_INDEX];
            int amount = Integer.parseInt(splitLine[AMOUNT_INDEX]);
            fruitOperation.setFruit(nameFruit);
            fruitOperation.setAmount(amount);
            fruitOperation.setOperation(FruitOperation.Operation.defineOperationByLetter(letter));
            fruitOperations.add(fruitOperation);
        }
        return fruitOperations;
    }
}
