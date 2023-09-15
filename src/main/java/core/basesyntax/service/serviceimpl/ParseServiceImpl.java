package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<FruitTransaction>();
        for (String line : lines) {
            String[] lineElements = line.split(",");
            OperationType operationType = OperationType.getOperationType(lineElements[0]);
            String fruitName = lineElements[1];
            int amount = Integer.parseInt(lineElements[2]);
            fruitTransactionList.add(new FruitTransaction(operationType, fruitName, amount));
        }
        return fruitTransactionList;
    }
}
