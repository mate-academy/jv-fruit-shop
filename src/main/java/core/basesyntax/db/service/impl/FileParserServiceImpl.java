package core.basesyntax.db.service.impl;

import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.FileParserService;
import java.util.ArrayList;
import java.util.List;

public class FileParserServiceImpl implements FileParserService {
    private static final String REGEX = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> inputFile) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction: inputFile) {
            String[] arr = transaction.split(REGEX);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationStrChar(arr[INDEX_OPERATION]);
            String fruit = arr[INDEX_FRUIT];
            int quantity = Integer.parseInt(arr[INDEX_QUANTITY]);
            resultList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return resultList;
    }
}
