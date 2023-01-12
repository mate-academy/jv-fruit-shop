package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.FruitParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitParserServiceImpl implements FruitParserService {

    @Override
    public List<FruitTransaction> parse(List<String> input) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction: input) {
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
