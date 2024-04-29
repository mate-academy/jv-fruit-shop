package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserServiceImpl implements ParserService {
    private static final int CODE_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        boolean firstLine = true;
        for (String line : lines) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] parts = line.split(SEPARATOR);
            if (parts.length != 3) {
                continue;
            }
            Optional<Operation> operation = Operation.fromString(parts[CODE_POSITION]);
            if (operation.isEmpty()) {
                continue;
            }
            String fruit = parts[FRUIT_POSITION];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_POSITION]);
            } catch (NumberFormatException e) {
                continue;
            }
            operation.ifPresent(value -> fruitTransactionList
                    .add(new FruitTransaction(value, fruit, quantity)));
        }
        return fruitTransactionList;
    }
}
