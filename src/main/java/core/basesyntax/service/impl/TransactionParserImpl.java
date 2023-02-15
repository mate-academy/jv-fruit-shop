package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int HEAD_LINE = 0;
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final String VALID_DATA = "[bprs],[a-z]*,[0-9]*";

    @Override
    public List<FruitTransaction> parseLine(List<String> data) {
        isValidData(data);
        return data.stream()
                .skip(HEAD_LINE)
                .map(this::parseLineToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLineToFruitTransaction(String line) {
        String[] splitLine = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getOperation(splitLine[INDEX_OPERATION])
        );
        fruitTransaction.setFruit(splitLine[INDEX_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLine[INDEX_AMOUNT]));
        return fruitTransaction;
    }

    public void isValidData(List<String> inputData) {
        if (inputData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        for (String str : inputData) {
            if (!Pattern.matches(VALID_DATA, str) && !str.equals("type,fruit,quantity")) {
                throw new RuntimeException("Invalid input data");
            }
        }
    }
}
