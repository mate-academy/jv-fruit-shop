package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(String data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] lines = data.split(System.lineSeparator());
        Arrays.stream(lines)
                .skip(1)
                .map(this::parseLine)
                .forEach(transactions::add);
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] splittedLine = line.split(",");
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.getOperationByLetter(splittedLine[OPERATION_INDEX]));
        transaction.setFruit(splittedLine[FRUIT_INDEX]);
        transaction.setQuantity(Integer.parseInt(splittedLine[AMOUNT_INDEX]));
        return transaction;
    }

}
