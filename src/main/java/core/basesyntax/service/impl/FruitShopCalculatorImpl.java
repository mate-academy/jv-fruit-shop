package core.basesyntax.service.impl;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.db.FruitShopDaoImpl;
import core.basesyntax.service.FruitShopCalculator;
import java.util.ArrayList;
import java.util.List;

public class FruitShopCalculatorImpl implements FruitShopCalculator {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private FruitShopDao fruitShop = new FruitShopDaoImpl();

    @Override
    public List<Integer> calculator(List<String> fruits, List<String> fromFile) {
        //2.a) calculate balance
        List<String> balanceFruits = fruitShop.calculate(fruits, fromFile,BALANCE);

        //2.b) calculate supply
        List<String> supplyFruits = fruitShop.calculate(fruits, fromFile,SUPPLY);

        //2.c) calculate purchase
        List<String> purchaseFruits = fruitShop.calculate(fruits, fromFile,PURCHASE);

        //2.d) calculate returns
        List<String> returnFruits = fruitShop.calculate(fruits, fromFile,RETURN);

        //2.e) add everything
        List<Integer> fruitAmount = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            int amount = amountFruits(balanceFruits, i)
                    + amountFruits(supplyFruits, i)
                    + amountFruits(returnFruits, i)
                    - amountFruits(purchaseFruits, i);

            fruitAmount.add(amount);
        }
        return fruitAmount;
    }

    private static Integer amountFruits(List<String> amountFruits, int i) {
        return Integer.valueOf(amountFruits.get(i));
    }
}
