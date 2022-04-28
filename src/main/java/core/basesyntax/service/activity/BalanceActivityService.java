package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.GetListOfActivity;
import core.basesyntax.service.GetListOfActivityImpl;
import java.util.List;

public class BalanceActivityService implements ActivityService {
    private static final int FRUIT_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final String ACTIVITY = "b";
    private FruitDao fruitDao;

    public BalanceActivityService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        GetListOfActivity getListOfActivity = new GetListOfActivityImpl();
        List<String> balanceList = getListOfActivity.getListOfActivity(inputData, ACTIVITY);
        for (String s : balanceList) {
            String fruitName = s.split(",")[FRUIT_INDEX];
            int fruitAmount = Integer.parseInt(s.split(",")[AMOUNT_INDEX]);
            new FruitServiceImpl(new FruitDaoImpl()).createNewFruit(fruitName, fruitAmount);
        }
    }
}
