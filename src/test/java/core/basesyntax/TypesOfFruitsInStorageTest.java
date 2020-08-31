package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TypesOfFruitsInStorageTest {
    private TypesOfFruitsInStorage typesOfFruitsInStorage = new TypesOfFruitsInStorage();
    private Storage storage = new Storage();

    @Test(expected = RuntimeException.class)
    public void toGetTypesFromEmptyStorage() {
        typesOfFruitsInStorage.getTypesOfFruits(storage);
    }

    @Test
    public void toGetTypesOk() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        FruitPackage fruitPostApple = new FruitPackage("apple", 4, localDateApple);
        FruitPackage fruitPostOrange = new FruitPackage("orange", 33, localDateApple);
        FruitPackage fruitPostLime = new FruitPackage("lime", 12, localDateApple);
        FruitPackage fruitPostLime2 = new FruitPackage("lime", 11, localDateApple);
        storage.getFruitPackages().add(fruitPostApple);
        storage.getFruitPackages().add(fruitPostOrange);
        storage.getFruitPackages().add(fruitPostLime);
        storage.getFruitPackages().add(fruitPostLime2);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("apple");
        expectedList.add("orange");
        expectedList.add("lime");
        Assert.assertEquals(expectedList, typesOfFruitsInStorage.getTypesOfFruits(storage));
    }
}
