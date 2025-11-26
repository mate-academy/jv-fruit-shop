package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OF_HEADER = 0;
    private static final String DELIMITER = ",";
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_OPERATION = 0;

    @Override
    public List<FruitTransaction> convertFruitTransactions(List<String> listTransactionFromFile) {
        if (listTransactionFromFile == null) {
            throw new RuntimeException("List transaction empty");
        }

        return updateDataInStorage(listTransactionFromFile);
    }

    private List<FruitTransaction> updateDataInStorage(List<String> readData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        readData.remove(INDEX_OF_HEADER);
        for (String line : readData) {
            FruitTransaction transaction = new FruitTransaction();
            String[] separatedData = line.split(DELIMITER);
            checkValidationSlitString(separatedData);
            transaction.setName(separatedData[INDEX_OF_FRUIT]);
            transaction.setQuantity(Integer.parseInt(separatedData[INDEX_OF_QUANTITY]));
            transaction.setOperation(
                    FruitTransaction.Operation.getCode(separatedData[INDEX_OF_OPERATION]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }

    private void checkValidationSlitString(String[] splitString) {
        if (splitString.length != 3) {
            throw new RuntimeException("Split string != 3");
        }
        if (Integer.parseInt(splitString[2]) < 0) {
            throw new RuntimeException("Quantity negative value");
        }
    }
}

