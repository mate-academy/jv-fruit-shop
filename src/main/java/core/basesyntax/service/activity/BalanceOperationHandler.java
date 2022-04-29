package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.GetDataFromListOfActivityImpl;
import core.basesyntax.service.GetListOfActivity;
import core.basesyntax.service.GetListOfActivityImpl;
import java.util.List;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        GetListOfActivity getListOfActivity = new GetListOfActivityImpl();
        List<String> balanceList = getListOfActivity.getListOfActivity(inputData, Operation.BALANCE);
        for (String string : balanceList) {
            String fruitName = new GetDataFromListOfActivityImpl().getFruitName(string);
            int fruitAmount = new GetDataFromListOfActivityImpl().getFruitAmount(string);
            new FruitDaoImpl().addNew(fruitName, fruitAmount);
        }
    }
}
