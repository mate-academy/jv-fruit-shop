package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.DataLineServiceImpl;
import core.basesyntax.service.SeparateOperationService;
import core.basesyntax.service.SeparateOperationServiceImpl;
import java.util.List;

public class PurchaseHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        SeparateOperationService purchaseListOfActivity = new SeparateOperationServiceImpl();
        List<String> purchaseList = purchaseListOfActivity
                .getListOfActivity(inputData, Operation.PURCHASE);
        for (String string : purchaseList) {
            String fruitName = new DataLineServiceImpl().getFruitName(string);
            int fruitAmount = new DataLineServiceImpl().getFruitAmount(string);
            if (fruitDao.get(fruitName) != null) {
                Fruit fruit = fruitDao.get(fruitName);
                int newFruitAmount = fruit.getAmount() - fruitAmount;
                fruit.setAmount(newFruitAmount);
            } else {
                throw new RuntimeException("Error in input data. "
                        + "It's impossible to sell a non-existent product");
            }
        }
    }
}
