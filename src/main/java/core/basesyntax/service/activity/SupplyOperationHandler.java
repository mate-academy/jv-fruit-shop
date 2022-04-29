package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.GetDataFromListOfActivityImpl;
import core.basesyntax.service.GetListOfActivity;
import core.basesyntax.service.GetListOfActivityImpl;
import java.util.List;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        GetListOfActivity supplyListOfActivity = new GetListOfActivityImpl();
        List<String> supplyList = supplyListOfActivity.getListOfActivity(inputData, Operation.SUPPLY);
        for (String string : supplyList) {
            String fruitName = new GetDataFromListOfActivityImpl().getFruitName(string);
            int fruitAmount = new GetDataFromListOfActivityImpl().getFruitAmount(string);
            if (fruitDao.get(fruitName) != null) {
                Fruit fruit = fruitDao.get(fruitName);
                int newFruitAmount = fruit.getAmount() + fruitAmount;
                fruit.setAmount(newFruitAmount);
            } else {
                new FruitDaoImpl().addNew(fruitName, fruitAmount);
            }
        }
    }
}
