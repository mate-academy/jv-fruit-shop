package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> textReport) {
        return textReport.stream()
                .skip(1)
                .map(str -> str.split(SPLITERATOR))
                .map(strArr -> new FruitTransaction(Operation.getOperationType(
                        strArr[OPERATION_TYPE_INDEX]), strArr[FRUIT_TYPE_INDEX],
                        Integer.parseInt(strArr[FRUIT_QUANTITY_INDEX])))
                .toList();
    }
}
