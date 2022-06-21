package servicecsv.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import servicecsv.DataHandler;

public class DataHandlerImpl implements DataHandler {
    private Map<String, FruitTransaction.Operation> transactionHandlerMap;

    public DataHandlerImpl(Map<String, FruitTransaction.Operation> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public List<FruitTransaction> handleData(List<String[]> transactions) {
        return transactions.stream()
                .map(i -> new FruitTransaction(
                        transactionHandlerMap.get(i[0]), i[1], Integer.parseInt(i[2])))
                .collect(Collectors.toList());
    }
}
