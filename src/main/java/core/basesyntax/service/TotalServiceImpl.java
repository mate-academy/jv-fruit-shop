package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TotalServiceImpl implements TotalService {
    private static final FruitTransaction.Operation OPERATION_TOTAL =
            FruitTransaction.Operation.TOTAL;
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String WORD_DELI = ",";
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String getReport() {
        List<FruitTransaction> fruitList = Storage.fruitTransactions.stream()
                .filter(s -> s.getOperation().equals(OPERATION_TOTAL))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(NEW_LINE);
        for (FruitTransaction fruitTransaction : fruitList) {
            builder.append(fruitTransaction.getFruit()).append(WORD_DELI)
                    .append(fruitTransaction.getQuantity()).append(NEW_LINE);
        }
        return builder.toString();
    }
}
