package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseReaderService;
import core.basesyntax.service.operationhandler.Operation;
import java.util.ArrayList;
import java.util.List;

public class ParseReaderServiceImpl implements ParseReaderService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitList(List<String> dataFromFile) {
        List<FruitTransaction> fruitList = new ArrayList<>();
        for (String data : dataFromFile) {
            String[] lineData = data.split(SEPARATOR);
            fruitList.add(new FruitTransaction(Operation.get(lineData[OPERATION_TYPE_INDEX]),
                    lineData[FRUIT_NAME_INDEX],
                    Integer.parseInt(lineData[FRUIT_AMOUNT_INDEX])));
        }
        return fruitList;

    }
}
