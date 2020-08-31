package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvailableFruitPackagesTest {
    private AvailableFruitPackages availableFruitPackages = new AvailableFruitPackages();
    private Storage storage = new Storage();
    private FruitPackage order = new FruitPackage("banana", 15, LocalDate.parse("2020-09-15"));

    @Test
    public void toGetAvailableFruitPackagesOk() {
        LocalDate localDateBanana1 = LocalDate.parse("2020-09-22");
        LocalDate localDateBanana2 = LocalDate.parse("2020-09-12");
        FruitPackage fruitPackageBanana1 = new FruitPackage("banana", 10, localDateBanana1);
        FruitPackage fruitPackageBanana2 = new FruitPackage("banana", 10, localDateBanana2);
        FruitPackage fruitPackageLime = new FruitPackage("lime", 12, localDateBanana2);
        storage.getFruitPackages().add(fruitPackageBanana1);
        storage.getFruitPackages().add(fruitPackageBanana2);
        storage.getFruitPackages().add(fruitPackageLime);
        List<FruitPackage> expectedList = new ArrayList<>();
        expectedList.add(fruitPackageBanana1);
        Assert.assertEquals(expectedList.size(), availableFruitPackages.toGetAvailableFruitPackages(order, storage).size());
        Assert.assertEquals(expectedList.get(0).getDate(), availableFruitPackages.toGetAvailableFruitPackages(order, storage).get(0).getDate());
        Assert.assertEquals(expectedList.get(0).getAmount(), availableFruitPackages.toGetAvailableFruitPackages(order, storage).get(0).getAmount());
        Assert.assertEquals(expectedList.get(0).getType(), availableFruitPackages.toGetAvailableFruitPackages(order, storage).get(0).getType());
    }
}
