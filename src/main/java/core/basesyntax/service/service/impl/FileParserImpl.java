package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitModel;
import core.basesyntax.model.OperationModel;
import core.basesyntax.service.FileParserService;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParserService {
    private static final String separator = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<OperationModel> parse(List<String> listFromFile) {
        List<OperationModel> transactionList = new ArrayList<>();
        for (int i = 1; i < listFromFile.size(); i++) {
            OperationModel transaction = new OperationModel();
            String[] splitData = listFromFile.get(i).split(separator);
            OperationModel.Operation operation
                    = OperationModel.Operation.getOperationFromCode(splitData[OPERATION_INDEX]);
            FruitModel fruitType = FruitModel.getModelFromCode(splitData[FRUIT_TYPE_INDEX]);
            int amount = Integer.parseInt(splitData[QUANTITY_INDEX]);
            transaction.setOperation(operation);
            transaction.setFruit(fruitType);
            transaction.setQuantity(amount);
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
