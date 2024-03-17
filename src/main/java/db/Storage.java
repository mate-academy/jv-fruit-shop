package db;

import model.FruitTransaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Storage {
    //method synchronized was used to make the list thread safe
    public final List<FruitTransaction> transactions =
            Collections.synchronizedList(new ArrayList<>());

    public void addTransaction(FruitTransaction transaction) {
        transactions.add(transaction);
    }

//    public List<FruitTransaction> getTransactions() {
//        return transactions.stream().toList();
//    }

    public List<FruitTransaction> getTransactions() {
        return transactions;
    }
}
