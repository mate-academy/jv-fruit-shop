package dao;

import db.FruitStorage;
import java.util.List;
import model.FruitTransaction;
import model.StoreOperation;

public class FruitStoreDaoImpl implements FruitStoreDao {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String COMA = ",";

    @Override
    public void addDataToStorage(List<String> dataList) {
        for (int i = 1; i < dataList.size(); i++) {
            FruitStorage.fruitStore.add(new FruitTransaction(StoreOperation
                    .valueOfOperation(dataList.get(i).split(COMA)[OPERATION]),
                    dataList.get(i).split(COMA)[FRUIT],
                    Integer.parseInt(dataList.get(i).split(COMA)[AMOUNT])));
        }

    }
}
