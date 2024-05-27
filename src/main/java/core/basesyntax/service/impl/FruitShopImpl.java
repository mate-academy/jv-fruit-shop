package core.basesyntax.service.impl;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.db.FruitShopDaoImpl;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.FruitShopCalculator;
import java.util.List;

public class FruitShopImpl implements FruitShop {
    private FruitShopDao fruitShop = new FruitShopDaoImpl();
    private FruitShopCalculator fruitCalculator = new FruitShopCalculatorImpl();

    @Override
    public void calculateFruitAmount(String fromFileName, String toFileName) {
        //0.clear previous file
        fruitShop.clearReportFile(toFileName);
        //1.read File
        List<String> fromFile = fruitShop.getFromFile(fromFileName);

        //2.edit File
        //(how much fruits we have)
        List<String> fruits = fruitShop.getFruits(fromFile);
        int amountOfOfFruits = fruits.size();

        //2 calculate
        List<Integer> fruitAmount = fruitCalculator.calculator(fruits, fromFile);
        //3.write report to new File
        fruitShop.reportFruitsToNewFile(fruits,fruitAmount,toFileName);
    }
}
