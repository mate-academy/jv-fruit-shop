package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.DataLineServiceImpl;
import core.basesyntax.service.SeparateOperationService;
import core.basesyntax.service.SeparateOperationServiceImpl;
import java.util.List;

public class ReturnHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        SeparateOperationService returnListOfActivity = new SeparateOperationServiceImpl();
        List<String> returnList = returnListOfActivity
                .getListOfActivity(inputData, Operation.RETURN);
        for (String string : returnList) {
            String fruitName = new DataLineServiceImpl().getFruitName(string);
            int fruitAmount = new DataLineServiceImpl().getFruitAmount(string);
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
