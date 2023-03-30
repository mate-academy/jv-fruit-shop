package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int HEAD_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final String VALID_DATA_EXPRESSION = "[bspr],[a-z]*,[0-9]*";

    @Override
    public List<FruitTransaction> parseList(List<String> data) {
        isValidData(data);
        data.remove(HEAD_LINE_INDEX);
        return data.stream()
                .map(this::parseLineToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLineToFruitTransaction(String line) {
        String[] splitLine = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getByCode(splitLine[OPERATION_INDEX])
        );
        fruitTransaction.setFruit(splitLine[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    public void isValidData(List<String> inputData) {
        for (String str : inputData) {
            if (!Pattern.matches(VALID_DATA_EXPRESSION, str)
                    && !str.equals("type,fruit,quantity")) {
                throw new RuntimeException("Invalid input data");
            }
        }
    }
}
