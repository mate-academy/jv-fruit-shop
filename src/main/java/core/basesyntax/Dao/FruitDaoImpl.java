package core.basesyntax.Dao;

import core.basesyntax.Db.Storage;
import core.basesyntax.Model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> getFirst(String operation) {
       return Storage.transactions.stream()
                .filter(transaction -> transaction.getOperation().getOperation().equals(operation))
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> get(String operation, String fruit) {
        List<FruitTransaction> list = new ArrayList<>();
        for (FruitTransaction tr : Storage.transactions) {
            if (tr.getFruit().equals(fruit) && tr.getOperation().getOperation().equals(operation)) {
                list.add(tr);
            }
        }
        return list;
    }
}
