package core.basesyntax.service.imp;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operations;
import core.basesyntax.service.ParsingService;
import java.util.ArrayList;
import java.util.List;

public class ParsingTransactionsImpl implements ParsingService {

    @Override
    public List<FruitTransaction> parsingTransactions(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] strings = list.get(i).split(",");
            Operations currentOperation = Operations.getByCode(strings[0]);
            int quantity = Integer.parseInt(strings[2]);
            FruitTransaction fruitTransaction = new FruitTransaction(currentOperation,
                    strings[1], quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
