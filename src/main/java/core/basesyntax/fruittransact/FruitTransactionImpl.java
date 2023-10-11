package core.basesyntax.fruittransact;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.FruitsDao;
import java.util.List;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;

    private FruitsDao fruitsDao = new FruitDaoImpl();

    @Override
    public void transact(String type, String name, int amount) {
        switch (type) {
            case "b":
                fruitsDao.set(name, amount);
                break;
            case "p":
                fruitsDao.remove(name, amount);
                break;
            case "s":
            case "r":
                fruitsDao.add(name, amount);
                break;
            default:
                throw new RuntimeException("No such transaction type: " + type);

        }
    }

    @Override
    public void transactAll(List<String[]> data) {
        for (String[] datum : data) {
            transact(datum[INDEX_OF_TYPE],
                    datum[INDEX_OF_FRUIT],
                    Integer.parseInt(datum[INDEX_OF_AMOUNT]));
        }
    }
}
