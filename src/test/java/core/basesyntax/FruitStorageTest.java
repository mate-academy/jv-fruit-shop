package core.basesyntax;

import dto.FruitDto;
import exceptions.ExpiredProductException;
import exceptions.NoValidOperationException;
import exceptions.NotEnoughQuantityException;
import model.Fruit;
import model.FruitStorage;
import operations.OperationContext;
import org.junit.Assert;
import org.junit.Test;
import services.StorageService;
import java.time.LocalDate;
import java.util.Map;

public class FruitStorageTest {
    private static final int ONE = 1;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int BIG_QUANTITY = 32000;
    private static final String VALID_DATAFILE_PATH = "src/test/resources/valid_data.csv";
    private static final String DATE_IN_PAST = "2000-12-12";
    private static final String DATE_IN_FUTURE = LocalDate.now().plusDays(ONE).toString();
    private static final String FRUIT_NAME = "banana";
    private static final String INVALID_OPERATION = "invalid operation";

    Fruit fruit = new Fruit(FRUIT_NAME, TEN, DATE_IN_FUTURE);
    Map<String, Fruit> testStorage = FruitStorage.storage;
    StorageService storageService = new StorageService();

    @Test
    public void addToStorageOkTest() {
        testStorage.put(fruit.getName(), fruit);
        Assert.assertEquals(ONE, testStorage.size());
        Fruit actualFruit = testStorage.get(fruit.getName());
        Assert.assertSame(actualFruit, fruit);
    }

    @Test
    public void buyTestOk() {
        testStorage.put(FRUIT_NAME, fruit);
        storageService.buy(FRUIT_NAME, FIVE);
        int expected = FIVE;
        int actual = testStorage.get(FRUIT_NAME).getQuantity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFruitFreshTest() {
        LocalDate now = LocalDate.now();
        fruit.setDate(DATE_IN_PAST);
        Assert.assertFalse(storageService.isFresh(fruit));
        fruit.setDate(now.plusDays(ONE).toString());
        Assert.assertTrue(storageService.isFresh(fruit));
    }

    @Test
    public void isNotEnoughQuantityTest() {
        testStorage.put(fruit.getName(), fruit);
        boolean actual = storageService.isEnough(fruit.getName(), BIG_QUANTITY);
        Assert.assertFalse(actual);
    }

    @Test
    public void isEnoughQuantityTest() {
        testStorage.put(fruit.getName(), fruit);
        boolean actual = storageService.isEnough(fruit.getName(), FIVE);
        Assert.assertTrue(actual);
    }

    @Test(expected = NoValidOperationException.class)
    public void wrongOperationTest() {
        FruitDto fruitDto = new FruitDto(INVALID_OPERATION, FRUIT_NAME, FIVE, DATE_IN_FUTURE);
        OperationContext operationContext = new OperationContext();
        operationContext.operateSwitcher(fruitDto);
    }

    @Test(expected = ExpiredProductException.class)
    public void ExpiredProductExceptionTest() {
        fruit.setDate(DATE_IN_PAST);
        storageService.put(fruit);
    }

    @Test(expected = NotEnoughQuantityException.class)
    public void NotEnoughQuantityExceptionTest() {
        fruit.setQuantity(FIVE);
        storageService.buy(FRUIT_NAME, TEN);
    }
}
