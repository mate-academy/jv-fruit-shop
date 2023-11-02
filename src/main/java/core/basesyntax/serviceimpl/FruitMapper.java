package core.basesyntax.serviceimpl;

import core.basesyntax.service.DataMapper;
import core.basesyntax.transaction.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper implements DataMapper {
    private static final String COMMA_SPLIT = ",";

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            String[] lineData = line.split(COMMA_SPLIT);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.getOperation(lineData[0]));
            fruitTransaction.setFruit(lineData[1]);
            fruitTransaction.setQuantity(Integer.parseInt(lineData[2]));
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }
}
