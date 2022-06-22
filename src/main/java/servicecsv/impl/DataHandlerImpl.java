package servicecsv.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.FruitTransaction;
import servicecsv.CheckedFunction;
import servicecsv.DataHandler;

public class DataHandlerImpl implements DataHandler {
    private Map<String, FruitTransaction.Operation> transactionHandlerMap;

    public DataHandlerImpl(Map<String, FruitTransaction.Operation> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public List<FruitTransaction> handleData(List<String[]> transactions) {
        return transactions.stream()
                .map(wrap(i -> new FruitTransaction(
                        transactionHandlerMap.get(i[0]), i[1], Integer.parseInt(i[2]))))
                .collect(Collectors.toList());
    }

    public static <T,R> Function<T,R> wrap(CheckedFunction<T,R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException("Your data doesn't correspond required parameters.");
            }
        };
    }
}
