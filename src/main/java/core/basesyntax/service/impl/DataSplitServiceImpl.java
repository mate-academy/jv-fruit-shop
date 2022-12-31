package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataSplitService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSplitServiceImpl implements DataSplitService {
    public static final int OPERATION_INDEX = 0;
    public static final int GOODS_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> splitData(String data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] lines = data.split(" ");
        Arrays.stream(lines)
                .skip(1)
                .forEach(l -> {
                    String[] splitLine = l.split(",");
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(splitLine[OPERATION_INDEX]);
                    transaction.setFruit(splitLine[GOODS_INDEX]);
                    transaction.setQuantity(Integer.parseInt(splitLine[AMOUNT_INDEX]));
                    transactions.add(transaction);
                });
        return transactions;
    }
}
