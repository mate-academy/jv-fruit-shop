package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReadFile;
import core.basesyntax.service.ReadFileImpl;
import java.util.ArrayList;
import java.util.List;

public class CsvFilrImplService implements CsvFileService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final ReadFile readFile = new ReadFileImpl();

    @Override
    public List<FruitTransaction> readFileToList(String fileCsvPath) {
        List<FruitTransaction> fruitList = new ArrayList<>();
        List<String> listFromFile = readFile.readFileToList(fileCsvPath);
        if (listFromFile != null) {
            for (int i = 0; i < listFromFile.size(); i++) {
                if (i != 0) {
                    String[] fruitOperation = listFromFile.get(i).split(",");
                    if (isAnOperation(fruitOperation)) {
                        FruitTransaction.Operation fruitCurrentOperation
                                = FruitTransaction.Operation.getFruitOperation(
                                        fruitOperation[OPERATION_INDEX]);
                        if (fruitCurrentOperation != null) {
                            FruitTransaction fruitTransaction
                                    = new FruitTransaction(fruitCurrentOperation,
                                    fruitOperation[FRUIT_NAME_INDEX],
                                    Integer.parseInt(fruitOperation[QUANTITY_INDEX]));
                            fruitList.add(fruitTransaction);
                        }

                    }
                }
            }
            return fruitList;
        }
        return fruitList;
    }

    private boolean isAnOperation(String[] line) {
        return line[OPERATION_INDEX] != null
                && line[FRUIT_NAME_INDEX] != null
                && line[QUANTITY_INDEX] != null;
    }
}
