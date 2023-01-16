package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationDaoImpl implements OperationDao {
    @Override
    public List<Operation> getListOperations() {
        List<Operation> operationList = new ArrayList<>();
        operationList.add(new Operation("BALANCE", "b", Operation.ArithmeticOperation.ADD));
        operationList.add(new Operation("SUPPLY", "s", Operation.ArithmeticOperation.ADD));
        operationList.add(new Operation("PURCHASE", "p", Operation.ArithmeticOperation.SUBTRACT));
        operationList.add(new Operation("RETURN", "r", Operation.ArithmeticOperation.SUBTRACT));
        return operationList;
    }
}
