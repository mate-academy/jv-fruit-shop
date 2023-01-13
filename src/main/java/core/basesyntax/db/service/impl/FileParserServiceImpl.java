package core.basesyntax.db.service.impl;

import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.FileParserService;
import java.util.ArrayList;
import java.util.List;

public class FileParserServiceImpl implements FileParserService {

    @Override
    public List<FruitTransaction> parse(List<String> inputFile) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction: inputFile) {
            String[] arr = transaction.split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationStrChar(arr[0]);
            String fruit = arr[1];
            int quantity = Integer.parseInt(arr[2]);
            resultList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return resultList;
    }
}
