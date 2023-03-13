package core.basesyntax.db.impl;

import core.basesyntax.db.FruitTransactionDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void saveAll(List<FruitTransaction> fruitTransactions) {
        Storage.listFruitTransactions.addAll(fruitTransactions);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return new ArrayList<>(Storage.listFruitTransactions);
    }

    @Override
    public List<Fruit> process() {
        List<FruitTransaction> fruitTransactionList = getAll();
        List<Fruit> fruitList = new ArrayList<>(Storage.listFruits);

        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            FruitTransaction.Operation operation = fruitTransaction.getOperation();
            int quantity = fruitTransaction.getQuantity();
            if (operation.equals(FruitTransaction.Operation.PURCHASE)) {
                quantity = -1 * quantity;
            }
            Fruit fruit = fruitList.stream()
                    .filter(entry -> entry.getFruit().equals(fruitTransaction.getFruit()))
                    .findFirst()
                    .orElse(null);
            if (fruit != null) {
                fruit.setQuantity(fruit.getQuantity() + quantity);
            } else {
                Storage.listFruits.add(new Fruit(fruitTransaction.getFruit(), quantity));
            }
        }

        return fruitList;
    }


}
