package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvailableAmountOfFruitsTest {
    private AvailableAmountOfFruits availableAmountOfFruits = new AvailableAmountOfFruits();

    @Test
    public void toGetAvailableAmountOfFruitsOk() {
        List<FruitPackage> fruitPackageList = new ArrayList<>();
        LocalDate localDate1 = LocalDate.parse("2020-07-12");
        LocalDate localDate2 = LocalDate.parse("2020-07-13");
        FruitPackage fruitPackage1 = new FruitPackage("banana", 10, localDate1);
        FruitPackage fruitPackage2 = new FruitPackage("banana", 100, localDate1);
        FruitPackage fruitPackage3 = new FruitPackage("banana", 50, localDate2);
        fruitPackageList.add(fruitPackage1);
        fruitPackageList.add(fruitPackage2);
        fruitPackageList.add(fruitPackage3);
        int expectedAmount = 160;
        Assert.assertEquals(expectedAmount, availableAmountOfFruits.toGetAvailableAmountOfFruits(fruitPackageList));
    }
}
