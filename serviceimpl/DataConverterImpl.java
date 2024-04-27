package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] data = line.split(SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperationByCode(data[OPERATION_INDEX]);
            String fruit = data[FRUIT_INDEX];
            int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
