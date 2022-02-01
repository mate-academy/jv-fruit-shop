package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.OperationHendler;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataProcessImpl implements DataProcess {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private Map<FruitTransaction.Operation,
            OperationHendler> operationHendlerMap;

    public DataProcessImpl(FruitDao fruitDao,
                           Map<FruitTransaction.Operation,
                                   OperationHendler> operationHendlerMap) {
        this.fruitDao = fruitDao;
        this.operationHendlerMap = operationHendlerMap;
    }

    @Override
    public void processingData(List<String> fileData) {
        for (FruitTransaction fruitTransaction : parsingData(fileData)) {
            operationHendlerMap.get(fruitTransaction.getOperation())
                    .getOperation(fruitDao, fruitTransaction);
        }
    }

    private List<FruitTransaction> parsingData(List<String> fileData) {
        return IntStream.range(0, fileData.size())
                .filter(i -> i != 0)
                .mapToObj(i -> fileData.get(i).split(SEPARATOR))
                .map(this::createObj)
                .collect(Collectors.toList());
    }

    private FruitTransaction createObj(String[] stringsArray) {
        validateData(stringsArray);
        FruitTransaction fruitTransaction = new FruitTransaction(stringsArray[1],
                Integer.parseInt(stringsArray[2]));
        fruitTransaction.setOperationByIndex(stringsArray[0]);
        return fruitTransaction;
    }

    private void validateData(String[] stringsArray) {
        if (stringsArray.length != 3) {
            throw new RuntimeException("You have error in data " + Arrays.toString(stringsArray)
                                        + ". Should be three elements.");
        }
        if (stringsArray[0] == null
                || stringsArray[1] == null
                || stringsArray[2] == null) {
            throw new RuntimeException("You have error in data " + Arrays.toString(stringsArray)
                    + ". Elements can't be null");
        }
    }
}
