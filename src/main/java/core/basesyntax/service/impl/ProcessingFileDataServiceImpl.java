package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessingFileDataService;
import java.util.ArrayList;
import java.util.List;

public class ProcessingFileDataServiceImpl implements ProcessingFileDataService {
    private static final String LINE_SEPARATOR = ",";
    private static final int PARAM_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> processingFileData(List<String> fileLines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            String[] parsedData = fileLines.get(i).split(LINE_SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getParamCode(FruitTransaction.Operation.class, parsedData[PARAM_INDEX]));
            fruitTransaction.setFruit(parsedData[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(parsedData[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
