package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.Operation;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationWithFruits {
    public static final Map<String, Operation> map = new HashMap<>();
    private FruitDao fruitDao = new FruitDaoImpl();

    static {
        map.put("s", new AddFruit());
        map.put("r", new AddFruit());
        map.put("b", new RemoveFruit());
    }

    public List<Fruit> operationWithFruits(List<Transaction> transaction)
            throws NotEnoughFruitsException {
        for (int i = 0; i < transaction.size(); i++) {
            String operationType = transaction.get(i).getTypeOfOperation();
            Operation operation = map.get(operationType);
            operation.apply(transaction.get(i));
        }
        return fruitDao.getAll();
    }
}
