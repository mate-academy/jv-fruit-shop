package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReadFile;
import core.basesyntax.service.ReadFileImpl;
import java.util.ArrayList;
import java.util.List;

public class CsvFilrImplService implements CsvFileService {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final String STRING_TO_ARRAY_SEPARATOR = ",";
    private static final ReadFile readFile = new ReadFileImpl();
    private final List<FruitTransaction> fruitList = new ArrayList<>();

    @Override
    public List<FruitTransaction> readFileToList(String fileCsvPath) {
        List<String> listFromFile = readFile.readFileToList(fileCsvPath);
        if (listFromFile != null && listFromFile.size() != 0) {
            for (int i = 0; i < listFromFile.size(); i++) {
                if (i != 0) {
                    String[] fruitOperation = listFromFile.get(i).split(STRING_TO_ARRAY_SEPARATOR);
                    if (isAnOperation(fruitOperation)) {
                        FruitTransaction.Operation fruitCurrentOperation
                                = FruitTransaction.Operation.getFruitOperstion(
                                        fruitOperation[OPERATION]);
                        if (fruitCurrentOperation != null) {
                            FruitTransaction fruitTransaction
                                    = new FruitTransaction(fruitCurrentOperation,
                                    fruitOperation[FRUIT_NAME],
                                    getQuantityInt(fruitOperation[QUANTITY]));
                            fruitList.add(fruitTransaction);
                        }

                    }
                }
            }
            return fruitList;
        }
        return fruitList;
    }

    private boolean isAnOperation(String[] strings) {
        return strings[OPERATION] != null
                && strings[FRUIT_NAME] != null
                && strings[QUANTITY] != null;
    }

    private int getQuantityInt(String quantity) {
        int result;
        try {
            result = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("this string is not a numeral " + quantity);
        }
        return result;
    }
}
