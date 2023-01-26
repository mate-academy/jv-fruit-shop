package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> getByOperation(String operation) {
        return Storage.transactions.stream()
                .filter(transaction -> transaction.getOperation().toString()
                        .equalsIgnoreCase(operation))
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> get() {
        return new ArrayList<>(Storage.transactions);
    }

    @Override
    public List<FruitTransaction> getFruitOperationsList(String operation, String fruit) {
        List<FruitTransaction> list = new ArrayList<>();
        for (FruitTransaction tr : Storage.transactions) {
            if (tr.getFruit().equals(fruit)
                    && tr.getOperation().toString().equals(operation)) {
                list.add(tr);
            }
        }
        return list;
    }
}
