package core.basesyntax.service;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.db.FruitShopDaoImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopImpl implements FruitShop{
    private FruitShopDao fruitShop = new FruitShopDaoImpl();
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public void calculateFruitAmount(String fromFileName, String toFileName) {
        //1.read File
        List<String> fromFile = fruitShop.getFromFile(fromFileName);

        //2.edit File
        //(how much fruits we have)
        List<String> fruits = fruitShop.getFruits(fromFile);
        int amountOfOurFruits = fruits.size();

        //2.a) calculate balance
        List<String> balanceFruits = fruitShop.calculate(fruits,BALANCE);

        //2.b) calculate supply
        List<String> supplyFruits = fruitShop.calculate(fruits,SUPPLY);

        //2.c) calculate purchase
        List<String> purchaseFruits = fruitShop.calculate(fruits,PURCHASE);

        //2.d) calculate returns
        List<String> returnFruits = fruitShop.calculate(fruits,RETURN);

        //2.e) mix everything
        HashMap<String, Integer> fruitsAmount = new HashMap<>();
        for (int i = 0; i < amountOfOurFruits; i++){
            int amount = amountFruits(balanceFruits, i)
                    + amountFruits(supplyFruits, i)
                    + amountFruits(purchaseFruits, i)
                    + amountFruits(returnFruits, i);

            fruitsAmount.put(fruits.get(i),amount);
        }

        //3.write report to new File
    }

    private static Integer amountFruits(List<String> balanceFruits, int i) {
        return Integer.valueOf(balanceFruits.get(i));
    }
}
