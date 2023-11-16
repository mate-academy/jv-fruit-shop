package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.exception.NoSuchOperationException;
import core.basesyntax.service.strategy.FruitResolver;
import core.basesyntax.service.strategy.OperationResolver;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String DELIMITER_COMMA = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private final TransactionDao translationDao;
    private final OperationResolver operationResolver;
    private final FruitResolver fruitResolver;

    public TransactionServiceImpl(TransactionDao translationDao,
                                  OperationResolver operationResolver,
                                  FruitResolver fruitResolver) {
        this.translationDao = translationDao;
        this.operationResolver = operationResolver;
        this.fruitResolver = fruitResolver;
    }

    @Override
    public FruitTransaction createNewTransaction(FruitTransaction transaction) {
        translationDao.add(transaction);
        return transaction;
    }

    @Override
    public FruitTransaction createInstance(String dataFromReport) {
        String[] strings = getArrayFromString(dataFromReport);
        return new FruitTransaction(
                operationResolver.getOperation(strings[INDEX_OPERATION]),
                fruitResolver.getFruit(strings[INDEX_FRUIT]),
                getQuantity(strings[INDEX_QUANTITY]));
    }

    @Override
    public void updateTransaction(FruitTransaction transaction) {
        FruitTransaction fruitTransaction = findTransactionByOperationAndFruit(transaction);
        translationDao.delete(fruitTransaction);
        int totalQuality = fruitTransaction.getQuantity() + transaction.getQuantity();
        fruitTransaction.setQuantity(totalQuality);
        translationDao.add(fruitTransaction);
    }

    @Override
    public FruitTransaction findTransactionByOperationAndFruit(FruitTransaction transaction) {
        List<FruitTransaction> list = translationDao.getAll();
        FruitTransaction fruitTransaction = list.stream()
                .filter(trans -> trans.getOperation() == transaction.getOperation()
                        && trans.getFruit() == transaction.getFruit())
                .findFirst().orElseThrow(
                        () -> new NoSuchOperationException("Transaction not found"));
        return fruitTransaction;
    }

    private String[] getArrayFromString(String fruitString) {
        return fruitString.split(DELIMITER_COMMA);
    }

    private int getQuantity(String string) {
        if (string == null || string.isEmpty()) {
            throw new NoSuchOperationException("Quantity is wrong");
        }
        int quantity = Integer.parseInt(string);
        if (quantity < 0) {
            throw new NoSuchOperationException("Quantity must be positive number, not " + quantity);
        }

        return quantity;
    }
}
