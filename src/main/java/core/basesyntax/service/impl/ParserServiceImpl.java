package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int MIN_NONNEGATIVE_INTEGER = 0;

    @Override
    public List<FruitTransaction> parse(List<String> fruitTransactions) {
        List<FruitTransaction> parsedFruitTransaction = new ArrayList<>();
        for (String line : fruitTransactions) {
            String[] splitLine = line.split(SEPARATOR);
            int quantity = Integer.parseInt(splitLine[QUANTITY]);
            if (Integer.parseInt(splitLine[QUANTITY]) >= MIN_NONNEGATIVE_INTEGER) {
                parsedFruitTransaction.add(new FruitTransaction(
                        FruitTransaction.Operation.getByCode(splitLine[OPERATION]),
                        splitLine[FRUIT_NAME],
                        quantity));
            } else {
                throw new RuntimeException(
                        "Quantity of fruits shouldn't be less than 0, but it was: "
                        + quantity);
            }
        }
        return parsedFruitTransaction;
    }
}
