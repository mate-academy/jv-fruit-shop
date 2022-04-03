package core.basesyntax.dao;

import core.basesyntax.db.ReadFile;
import core.basesyntax.db.ReadFileImpl;
import core.basesyntax.service.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataFromCsvFilrImpl implements DataFromCsvFile {
    public static final String STRING_TO_ARRAY_SEPARATOR = ",";
    private static final ReadFile readFile = new ReadFileImpl();
    private final List<FruitTransaction> fruitList = new ArrayList<>();

    @Override
    public List<FruitTransaction> readFileToList(String fileCsvPath) {
        List<String> listFromFile = readFile.readFileToList(fileCsvPath);
        if (listFromFile != null && listFromFile.size() != 0) {
            for (String s: listFromFile) {
                String[] fruitOperation = s.split(STRING_TO_ARRAY_SEPARATOR);
                if (isAnOperation(fruitOperation)) {
                    FruitTransaction.Operation fruitCurrentOperation
                            = getFruitOperstion(fruitOperation[OPERATION]);
                    if (fruitCurrentOperation != null) {
                        FruitTransaction fruitTransaction
                                = new FruitTransaction(fruitCurrentOperation,
                                fruitOperation[FRUIT_NAME],
                                getQuantityInt(fruitOperation[QUANTITY]));
                        fruitList.add(fruitTransaction);
                    }

                }
            }
            return fruitList;
        }
        return null;
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

    private FruitTransaction.Operation getFruitOperstion(String operation) {
        FruitTransaction.Operation[] fruitOperation = FruitTransaction.Operation.values();
        for (FruitTransaction.Operation o: fruitOperation) {
            if (o.getOperation().equals(operation)) {
                return o;
            }
        }

        return null;
    }
}
