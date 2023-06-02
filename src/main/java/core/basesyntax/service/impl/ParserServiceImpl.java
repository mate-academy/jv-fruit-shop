package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private final int operationCodeIndex;
    private final int quantityIndex;
    private final int fruitNameIndex;

    private final FruitTransactionService fruitTransactionService;

    public ParserServiceImpl() {
        operationCodeIndex = 0;
        quantityIndex = 2;
        fruitNameIndex = 1;
        fruitTransactionService = new FruitTransactionServiceImpl();
    }

    @Override
    public List<FruitTransaction> parseData(List<String> inputDataRows) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputDataRows.size(); i++) {
            String[] entryData = inputDataRows.get(i).split(",");
            String operationCode = entryData[operationCodeIndex];
            String fruit = entryData[fruitNameIndex];
            int quantity = Integer.parseInt(entryData[quantityIndex].trim());
            FruitTransaction transaction =
                    fruitTransactionService.createTransaction(operationCode, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
