package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BuyTest {
    private Buy buy = new Buy();
    private Storage storage = new Storage();
    private static final String FILE_PATH_TO_TEST_SEVERAL_OPERATIONS = "src/test/resources/testSeveralBuyOperations";
    private FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
    private OperationStrategy operationStrategy = new OperationStrategy();
    private DataParser dataParser = new DataParser();

    @Test()
    public void toBuyOkFromOneObject() {
        LocalDate localDate = LocalDate.of(2020, 4, 12);
        FruitPackage fruitPackagePost = new FruitPackage("banana", 100, localDate);
        storage.getFruitPackages().add(fruitPackagePost);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        FruitPackage fruitPackageSell = new FruitPackage("banana", 20, localDateBuying);
        buy.apply(fruitPackageSell, storage);
        FruitPackage fruitPackageRemaining = new FruitPackage("banana", 80, localDate);
        List<FruitPackage> expectedList = new ArrayList<>();
        expectedList.add(fruitPackageRemaining);
        Assert.assertEquals(expectedList.size(), storage.getFruitPackages().size());
        Assert.assertEquals(expectedList.get(0).getAmount(),
                storage.getFruitPackages().get(0).getAmount());
        Assert.assertEquals(expectedList.get(0).getDate(),
                storage.getFruitPackages().get(0).getDate());
        Assert.assertEquals(expectedList.get(0).getType(),
                storage.getFruitPackages().get(0).getType());
    }


    @Test(expected = IllegalArgumentException.class)
    public void toBuyAllFruitsAreOverdue() {
        LocalDate localDateBanana = LocalDate.of(2020, 4, 10);
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        FruitPackage fruitPostBanana = new FruitPackage("banana", 100, localDateBanana);
        FruitPackage fruitPostApple = new FruitPackage("apple", 34, localDateApple);
        storage.getFruitPackages().add(fruitPostBanana);
        storage.getFruitPackages().add(fruitPostApple);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        FruitPackage fruitPackageSell = new FruitPackage("banana", 20, localDateBuying);
        buy.apply(fruitPackageSell, storage);
    }

    @Test()
    public void toBuyOkFromSeveralObjects() {
        List<FruitPackage> expectedList = new ArrayList<>();
        FruitPackage fruitPackage1 = new FruitPackage("banana", 75, LocalDate.parse("2020-10-17"));
        FruitPackage fruitPackage2 = new FruitPackage("banana", 10, LocalDate.parse("2020-10-24"));
        expectedList.add(fruitPackage1);
        expectedList.add(fruitPackage2);
        List<List<String>> data = fileReaderService.readFile(FILE_PATH_TO_TEST_SEVERAL_OPERATIONS, ",");
        for(List<String> row : data){
            operationStrategy.fulfillAllOrders(row, storage, dataParser.mapToFruit(row));
        }
        Assert.assertEquals(expectedList.size(), storage.getFruitPackages().size());
        Assert.assertEquals(expectedList.get(0).getAmount(), storage.getFruitPackages().get(0).getAmount());
        Assert.assertEquals(expectedList.get(1).getAmount(), storage.getFruitPackages().get(1).getAmount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void toBuyNotEnoughFreshFruit() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        FruitPackage fruitPostApple = new FruitPackage("apple", 4, localDateApple);
        storage.getFruitPackages().add(fruitPostApple);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        FruitPackage fruitPackageSell = new FruitPackage("apple", 20, localDateBuying);
        buy.apply(fruitPackageSell, storage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toBuyFruitWeDoNotHave() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        FruitPackage fruitPostApple = new FruitPackage("apple", 4, localDateApple);
        FruitPackage fruitPostOrange = new FruitPackage("orange", 33, localDateApple);
        FruitPackage fruitPostLime = new FruitPackage("lime", 12, localDateApple);
        storage.getFruitPackages().add(fruitPostApple);
        storage.getFruitPackages().add(fruitPostOrange);
        storage.getFruitPackages().add(fruitPostLime);
        FruitPackage fruitPackageSell = new FruitPackage("lemon", 4, localDateApple);
        buy.apply(fruitPackageSell, storage);
    }
}
