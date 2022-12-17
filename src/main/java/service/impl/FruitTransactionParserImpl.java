package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int INFORM_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(INFORM_LINE)
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());

    }

    private FruitTransaction createTransactionFromLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = line.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(fields[OPERATION_INDEX]));
        fruitTransaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
        fruitTransaction.setAmount(Integer.valueOf(fields[AMOUNT_INDEX]));
        return fruitTransaction;
    }
}
