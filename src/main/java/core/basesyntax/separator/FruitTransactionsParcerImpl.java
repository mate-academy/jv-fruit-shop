package core.basesyntax.separator;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionsParcerImpl implements FruitTransactionsParcer {
    private static final String SEPARATOR = ",";
    private static final int TITLE_LINE = 1;
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;

    @Override
    public List<Transaction> transactionsParcer(List<String> readLine) {
        return readLine.stream()
                .skip(TITLE_LINE)
                .map(s -> s.split(SEPARATOR))
                .map(s -> new Transaction(new Fruit(s[FRUIT_NAME],
                        Integer.parseInt(s[FRUIT_QUANTITY])),
                        Transaction.Type.getTypeOperation(s[TYPE_OPERATION_INDEX])))
                .collect(Collectors.toList());
    }
}
