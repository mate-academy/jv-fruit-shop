package serviceCSV.impl;

import Strategy.TransactionStrategy;
import model.FruitTransaction;
import serviceCSV.DataOperating;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
