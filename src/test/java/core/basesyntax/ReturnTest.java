package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ReturnTest {
    private Return ret = new Return();
    private Storage storage = new Storage();

    @Test()
    public void toReturnOk() {
        LocalDate localDate = LocalDate.of(2020, 4, 12);
        FruitPackage fruitBananaPackage = new FruitPackage("banana", 100, localDate);
        FruitPackage fruitApplePackage = new FruitPackage("apple", 34, localDate);
        storage.getFruitPackages().add(fruitBananaPackage);
        ret.toDo(fruitApplePackage, storage);
        Assert.assertEquals(fruitApplePackage.getType(),
                storage.getFruitPackages().get(storage.getFruitPackages().size() - 1).getType());
        Assert.assertEquals(fruitApplePackage.getAmount(),
                storage.getFruitPackages().get(storage.getFruitPackages().size() - 1).getAmount());
        Assert.assertEquals(fruitApplePackage.getDate(),
                storage.getFruitPackages().get(storage.getFruitPackages().size() - 1).getDate());
    }
}
