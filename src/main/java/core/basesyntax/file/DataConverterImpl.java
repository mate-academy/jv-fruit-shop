package core.basesyntax.file;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> dataToParse) {
        List<FruitTransaction> newList = new ArrayList<>();

        for (String line : dataToParse) {
            FruitTransaction transaction = new FruitTransaction();
            String[] separatedData = line.split(DELIMITER);
            Operation operation
                    = Operation.fromCode(separatedData[INDEX_OF_OPERATION]);
            transaction.setOperation(operation);
            transaction.setFruit(separatedData[INDEX_OF_FRUIT]);
            transaction.setQuantity(Integer.parseInt(separatedData[INDEX_OF_QUANTITY]));
            newList.add(transaction);
        }
        return newList;
    }
}
