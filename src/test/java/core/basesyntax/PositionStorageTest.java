package core.basesyntax;

import dto.PositionDto;
import exceptions.ExpiredProductException;
import exceptions.NoValidOperationException;
import exceptions.NotEnoughQuantityException;
import model.Position;
import model.Storage;
import operations.OperationContext;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.StorageService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PositionStorageTest {
    private static final int ONE = 1;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int BIG_QUANTITY = 32000;
    private static final LocalDate DATE_IN_PAST = LocalDate.parse("2000-12-12");
    private static final LocalDate DATE_IN_FUTURE = LocalDate.now().plusDays(ONE);
    private static final String FRUIT_NAME = "banana";
    private static final String INVALID_OPERATION = "invalid operation";

    private static Position position;
    private static Map<String, Position> testStorage;
    private static StorageService storageService;

    @BeforeClass
        public static void setUp() {
        position = new Position(FRUIT_NAME, TEN, DATE_IN_FUTURE);
        testStorage = Storage.storage;
        storageService = new StorageService();
    }

    @AfterClass
    public static void clearStorage() {
        testStorage.clear();
    }

    @Test
    public void addToStorageOkTest() {
        testStorage.clear();
        testStorage.put(position.getName(), position);
        Assert.assertEquals(ONE, testStorage.size());
        Position actualPosition = testStorage.get(position.getName());
        Assert.assertSame(actualPosition, position);
    }

    @Test
    public void buyTestOk() {
        setUp();
        testStorage.put(FRUIT_NAME, position);
        storageService.buy(FRUIT_NAME, FIVE);
        int expected = FIVE;
        int actual = testStorage.get(FRUIT_NAME).getQuantity();
        Assert.assertSame(expected, actual);
    }

    @Test
    public void isFruitFreshTest() {
        LocalDate now = LocalDate.now();
        position.setDate(DATE_IN_PAST);
        Assert.assertFalse(storageService.isFresh(position));
        position.setDate(now.plusDays(ONE));
        Assert.assertTrue(storageService.isFresh(position));
    }

    @Test
    public void isNotEnoughQuantityTest() {
        testStorage.put(position.getName(), position);
        boolean actual = storageService.isEnough(position.getName(), BIG_QUANTITY);
        Assert.assertFalse(actual);
    }

    @Test
    public void isEnoughQuantityTest() {
        testStorage.put(position.getName(), position);
        boolean actual = storageService.isEnough(position.getName(), FIVE);
        Assert.assertTrue(actual);
    }

    @Test(expected = NoValidOperationException.class)
    public void wrongOperationTest() {
        List<PositionDto> productsList = new ArrayList<>();
        productsList.add(new PositionDto(INVALID_OPERATION, FRUIT_NAME, FIVE, DATE_IN_FUTURE));
        OperationContext operationContext = new OperationContext();
        operationContext.operateSwitcher(productsList);
    }

    @Test(expected = ExpiredProductException.class)
    public void ExpiredProductExceptionTest() {
        position.setDate(DATE_IN_PAST);
        storageService.put(position);
    }

    @Test(expected = NotEnoughQuantityException.class)
    public void NotEnoughQuantityExceptionTest() {
        position.setQuantity(FIVE);
        storageService.put(position);
        storageService.buy(FRUIT_NAME, BIG_QUANTITY);
    }
}
