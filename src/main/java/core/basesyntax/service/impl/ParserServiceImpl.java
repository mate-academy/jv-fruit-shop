package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String[]> fileInfo) {
        List<String[]> transactionInfo = fileInfo.stream()
                .skip(1)
                .map(strings -> strings[0].split(";"))
                .collect(Collectors.toList());

        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        transactionInfo.forEach(transaction -> {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .identifyOperation(transaction[TYPE_INDEX]));
            fruitTransaction.setFruitName(transaction[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        });
        return fruitTransactions;
    }
}
