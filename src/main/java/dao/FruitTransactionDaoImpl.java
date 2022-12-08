package dao;

import db.Storage;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int INFORM_LINE = 1;
    private Storage storage;

    public FruitTransactionDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public boolean add(FruitTransaction fruitTransaction) {
        return storage.addData(fruitTransaction.toString());
    }

    @Override
    public List<FruitTransaction> getAll() {
        return storage.getData().stream()
                .skip(INFORM_LINE)
                .map(this::createTransactionFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromString(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = line.split(",");
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(fields[OPERATION_INDEX])) {
                fruitTransaction.setOperation(operation);
            }
        }
        fruitTransaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
        fruitTransaction.setAmount(new BigDecimal(fields[AMOUNT_INDEX]));
        return fruitTransaction;
    }
}
