package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.GetListOfActivity;
import core.basesyntax.service.GetListOfActivityImpl;
import java.util.List;

public class ReturnActivityService implements ActivityService {
    private static final int FRUIT_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final String ACTIVITY = "r";
    private FruitDao fruitDao;

    public ReturnActivityService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        GetListOfActivity returnListOfActivity = new GetListOfActivityImpl();
        List<String> returnList = returnListOfActivity.getListOfActivity(inputData, ACTIVITY);
        for (String s : returnList) {
            String fruitName = s.split(",")[FRUIT_INDEX];
            int fruitAmount = Integer.parseInt(s.split(",")[AMOUNT_INDEX]);
            if (fruitDao.get(fruitName) != null) {
                Fruit fruit = fruitDao.get(fruitName);
                int newFruitAmount = fruit.getAmount() + fruitAmount;
                fruit.setAmount(newFruitAmount);
            } else {
                new FruitServiceImpl(new FruitDaoImpl()).createNewFruit(fruitName, fruitAmount);
            }
        }
    }
}
