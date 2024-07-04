package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] inputToArray = inputReport.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction(FruitTransaction
                    .Operation.fromCode(inputToArray[OPERATION_TYPE_INDEX]),
                    inputToArray[FRUIT_NAME_INDEX],
                    Integer.parseInt(inputToArray[QUANTITY_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
