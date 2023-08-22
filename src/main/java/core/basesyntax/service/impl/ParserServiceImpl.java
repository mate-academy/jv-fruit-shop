package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_POSITION = 0;
    private static final int NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        if (lines.isEmpty()) {
            throw new RuntimeException("Data is empty.");
        }
        for (String line: lines) {
            String[] parsedLine = line.split(SEPARATOR);
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.getByCode(parsedLine[OPERATION_POSITION]);
            String name = parsedLine[NAME_POSITION];
            int quantity = Integer.parseInt(parsedLine[QUANTITY_POSITION]);

            fruitTransactions.add(new FruitTransaction(operation, name, quantity));
        }
        return fruitTransactions;
    }
}
