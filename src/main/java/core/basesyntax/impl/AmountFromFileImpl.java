package core.basesyntax.impl;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.AmountFromFile;
import core.basesyntax.db.FruitShopDao;

import java.util.ArrayList;
import java.util.List;

public class AmountFromFileImpl implements AmountFromFile {
    private FruitShopDao fruitShopDao;

    public AmountFromFileImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<Integer> getAmountInShop(List<String> fruits, List<FruitTransaction> fruitTransactions) {
        List<Integer> amounts = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            int sum = fruitTransactions.stream()
                    .filter(ft -> ft.getFruit().equals(fruit))
                    .mapToInt(n -> n.getOperation() == FruitTransaction.Operation.BALANCE ? n.getQuantity() :
                            n.getOperation() == FruitTransaction.Operation.SUPPLY ? n.getQuantity() :
                                    n.getOperation() == FruitTransaction.Operation.RETURN? n.getQuantity() :
                                            n.getQuantity() * -1)
                    .sum();
            amounts.add(sum);
            fruitShopDao.put(fruit,sum);
        }
        return amounts;
    }
}
