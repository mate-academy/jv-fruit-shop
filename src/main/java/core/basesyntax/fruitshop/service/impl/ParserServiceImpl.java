package core.basesyntax.fruitshop.service.impl;

import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String CSV_HEADER = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.equals(CSV_HEADER)) {
                continue;
            }
            String[] parts = line.split(SEPARATOR);
            FruitTransaction transaction = new FruitTransaction(
                    FruitTransaction.Operation.fromString(parts[OPERATION_INDEX]),
                    parts[FRUIT_INDEX],
                    Integer.parseInt(parts[QUANTITY_INDEX])
            );
            transactions.add(transaction);
        }
        return transactions;
    }
}
