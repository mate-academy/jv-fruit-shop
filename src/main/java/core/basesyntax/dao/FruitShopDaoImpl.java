package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public List<FruitTransaction> fruitFromString(String dataFromFile) {
        String[] fromFile = dataFromFile.split("\r\n");
        List<FruitTransaction> fruitList = new ArrayList<>();
        for (String line : fromFile) {
            String[] splited = line.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction
                    .setOperation(FruitTransaction.Operation.getOperationByCode(splited[0]));
            fruitTransaction.setFruit(splited[1]);
            fruitTransaction.setQuantity(Integer.parseInt(splited[2]));
            fruitList.add(fruitTransaction);
        }
        return fruitList;
    }
}
