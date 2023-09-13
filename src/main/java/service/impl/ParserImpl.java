package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;
    private static final String delimiter = ",";

    @Override
    public List<FruitTransaction> parseFile(List<String> fileContent) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        FruitTransaction fruitTransaction;

        for (String line : fileContent) {
            String[] lineSplit = line.split(",");
            fruitTransaction = new FruitTransaction(
                    Operation.valueOfCode(lineSplit[OPERATION_POSITION]),
                    lineSplit[FRUIT_POSITION],
                    Integer.parseInt(lineSplit[AMOUNT_POSITION]));
            fruitTransactions.add(fruitTransaction);
        }

        return fruitTransactions;
    }
}
