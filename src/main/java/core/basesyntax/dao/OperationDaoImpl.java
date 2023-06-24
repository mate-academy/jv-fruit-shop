package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationDaoImpl implements OperationDao {
    @Override
    public List<Operation> getListOperations() {
        List<Operation> listOperations = new ArrayList<>();
        listOperations.add(new Operation("BALANCE", "b", Operation.ArithmeticOperation.ADD));
        listOperations.add(new Operation("SUPPLY", "s", Operation.ArithmeticOperation.ADD));
        listOperations.add(new Operation("PURCHASE", "p", Operation.ArithmeticOperation.SUBTRACT));
        listOperations.add(new Operation("RETURN", "r", Operation.ArithmeticOperation.SUBTRACT));
        return listOperations;
    }
}
