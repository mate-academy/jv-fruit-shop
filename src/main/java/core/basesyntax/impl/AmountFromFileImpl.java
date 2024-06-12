package core.basesyntax.impl;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.service.AmountFromFile;
import core.basesyntax.service.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class AmountFromFileImpl implements AmountFromFile {
    private FruitShopDao fruitShopDao;

    public AmountFromFileImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<Integer> getAmountInShop(List<String> fruits,
                                         List<FruitTransaction> fruitTransactions) {
        List<Integer> amounts = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            int sum = fruitTransactions.stream()
                    .filter(ft -> ft.getFruit().equals(fruit))
                    .mapToInt(n -> calculateQantityFromOperation(n))
                    .sum();
            amounts.add(sum);
            fruitShopDao.put(fruit,sum);
        }
        return amounts;
    }

    private static int calculateQantityFromOperation(FruitTransaction transaction) {
        return transaction.getOperation() == FruitTransaction.Operation.BALANCE
                ? transaction.getQuantity()
                : transaction.getOperation() == FruitTransaction.Operation.SUPPLY
                ? transaction.getQuantity()
                : transaction.getOperation() == FruitTransaction.Operation.RETURN
                ? transaction.getQuantity() : transaction.getQuantity() * -1;//purchase
    }
}
