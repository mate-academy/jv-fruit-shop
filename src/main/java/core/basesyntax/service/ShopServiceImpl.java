package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private ActionStrategy strategy = new ActionStrategyImpl();

    @Override
    public void generate(List<FruitTransaction> listOfAllTransactions) {
        for (int i = 0; i < listOfAllTransactions.size(); i++) {
            generateByRow(listOfAllTransactions.get(i));
        }
    }

    void generateByRow(FruitTransaction transaction) {
        strategy.get(transaction.getOperation())
                .count(transaction.getFruit(), transaction.getQuantity());
    }
}
