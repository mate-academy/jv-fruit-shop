package core.basesyntax.db;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private Map<Operation, List<Transaction>> data;
    public void addTransactions(List<Transaction> transactionList){
       this.data = transactionList.stream()
               .collect(Collectors.groupingBy(Transaction::getOperation));
    }
}
