package servicecsv.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import model.FruitTransaction;
import servicecsv.DataOperating;
import strategy.TransactionStrategy;

public class DataOperatingImpl implements DataOperating {
    private TransactionStrategy transactionStrategy;

    public DataOperatingImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public List<FruitTransaction> passFruitData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransaction = new ArrayList<>();
        Consumer<String[]> parseConsumer = strings ->
                fruitTransaction
                        .add(new FruitTransaction(transactionStrategy
                                .get(strings[0]), strings[1], Integer.parseInt(strings[2])));
        dataFromFile.stream().map(s -> s.split(",")).skip(1).forEach(parseConsumer);

        return fruitTransaction;
    }
}
