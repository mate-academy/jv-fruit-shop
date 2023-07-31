package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTranzactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionService;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String COMMA = ",";
    private final FruitTranzactionDao fruitTranzactionDao = new FruitTransactionDaoImpl();

    @Override
    public void createNewFruitTransaction(List<String> fileData) {
        for (String data : fileData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] dataValue = data.split(COMMA);

            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(dataValue[INDEX_OPERATION])) {
                    fruitTransaction.setOperation(operation);
                    break;
                }
            }
            fruitTransaction.setFruit(dataValue[INDEX_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(dataValue[INDEX_QUANTITY]));
            fruitTranzactionDao.add(fruitTransaction);
        }
    }
}
