package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TotalService;
import java.util.List;
import java.util.stream.Collectors;

public class TotalServiceImpl implements TotalService {
    private static final FruitTransaction.Operation TOTAL =
            FruitTransaction.Operation.TOTAL;
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String COMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        List<FruitTransaction> fruitList = Storage.fruitTransactions.stream()
                .filter(s -> s.getOperation().equals(TOTAL))
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COLUMN_NAMES).append(LINE_SEPARATOR);
        for (FruitTransaction fruitTransaction : fruitList) {
            stringBuilder.append(fruitTransaction.getFruit()).append(COMA)
                    .append(fruitTransaction.getQuantity()).append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
