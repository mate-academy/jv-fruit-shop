package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final List<FruitTransaction> transactions = new ArrayList<>();

    @Override
    public List<FruitTransaction> parseData(String data) {
        String[] lines = data.split(System.lineSeparator());
        Arrays.stream(lines)
                .skip(1)
                .forEach(parseLines());
        return transactions;
    }

    private Consumer<String> parseLines() {
        return line -> {
            String[] splittedLine = line.split(",");
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(splittedLine[OPERATION_INDEX]);
            transaction.setFruit(splittedLine[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(splittedLine[AMOUNT_INDEX]));
            transactions.add(transaction);
        };
    }
}
