package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.DataLineServiceImpl;
import core.basesyntax.service.SeparateOperationService;
import core.basesyntax.service.SeparateOperationServiceImpl;
import java.util.List;

public class BalanceHandler implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void activity(List<String> inputData) {
        SeparateOperationService separateOperationService = new SeparateOperationServiceImpl();
        List<String> balanceList = separateOperationService
                .getListOfActivity(inputData, Operation.BALANCE);
        for (String string : balanceList) {
            String fruitName = new DataLineServiceImpl().getFruitName(string);
            int fruitAmount = new DataLineServiceImpl().getFruitAmount(string);
            new FruitDaoImpl().addNew(fruitName, fruitAmount);
        }
    }
}
