package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (lines.isEmpty()) {
            throw new RuntimeException("The file is empty");
        }
        String actualHeader = lines.get(0);
        if (!actualHeader.equals(HEADER)) {
            throw new RuntimeException("Incorrect header. "
                    + "Header must be equal to: 'type,fruit,quantity'");
        }
        for (int i = 1; i < lines.size(); i++) {
            List<String[]> arrayLines = lines.stream()
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());
            Object[] objectsInString = Arrays.stream(arrayLines.get(i)).toArray();
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperation(String.valueOf(objectsInString[OPERATION_INDEX])));
            fruitTransaction.setFruit(String.valueOf(objectsInString[FRUIT_INDEX]));
            fruitTransaction.setQuantity(Integer
                    .parseInt(String.valueOf(objectsInString[QUANTITY_INDEX])));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
