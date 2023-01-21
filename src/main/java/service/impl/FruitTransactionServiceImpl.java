package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_COMMA = ",";

    @Override
    public List<FruitTransaction> getFruitTransactionData(List<String> dailyData) {
        return dailyData.stream()
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String data) {
        String[] info = data.split(SPLIT_COMMA);
        return new FruitTransaction(info[OPERATION_INDEX], info[FRUIT_INDEX],
                Integer.parseInt(info[QUANTITY_INDEX]));
    }
}
