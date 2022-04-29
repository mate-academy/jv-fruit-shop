package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.GetDataFromListOfActivityImpl;
import core.basesyntax.service.GetListOfActivity;
import core.basesyntax.service.GetListOfActivityImpl;
import java.util.List;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        GetListOfActivity purchaseListOfActivity = new GetListOfActivityImpl();
        List<String> purchaseList = purchaseListOfActivity.getListOfActivity(inputData, Operation.PURCHASE);
        for (String string : purchaseList) {
            String fruitName = new GetDataFromListOfActivityImpl().getFruitName(string);
            int fruitAmount = new GetDataFromListOfActivityImpl().getFruitAmount(string);
            if (fruitDao.get(fruitName) != null) {
                Fruit fruit = fruitDao.get(fruitName);
                int newFruitAmount = fruit.getAmount() - fruitAmount;
                fruit.setAmount(newFruitAmount);
            } else {
                throw new RuntimeException("Error in input data. It's impossible to sell a non-existent product");
            }
        }
    }
}
