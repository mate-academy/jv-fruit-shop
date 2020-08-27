package core.basesyntax.service;

import core.basesyntax.FruitBatch;
import core.basesyntax.FruitDto;
import core.basesyntax.FruitStorage;
import org.junit.BeforeClass;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FruitStorageUpdaterTest {
    private static FruitStorageUpdater fruitStorageUpdater = new FruitStorageUpdater();
    private static List<FruitDto> fruitDtos = new ArrayList<>();
    private static String TRANSACTION_TYPE_BUY = "b";
    private static final String TRANSACTION_TYPE_SUPPLY = "s";
    private static final String TRANSACTION_TYPE_RETURN = "r";
    private static final String FRUIT_TYPE = "banana";
    private static final int QUANTITY_ONE = 100;
    private static final int QUANTITY_TWO = 15;
    private static final int QUANTITY_THREE = 2;
    private static final LocalDate DATE_ONE = LocalDate.of(2020, 11, 1);
    private static final LocalDate DATE_TWO = LocalDate.of(2020, 10, 10);

    @BeforeClass
    public static void setUp() {
        FruitDto fruitDtoOne = new FruitDto();
        fruitDtoOne.setTransaction(TRANSACTION_TYPE_SUPPLY);
        fruitDtoOne.setFruitType(FRUIT_TYPE);
        fruitDtoOne.setQuantity(QUANTITY_ONE);
        fruitDtoOne.setDate(DATE_ONE);
        FruitDto fruitDtoTwo = new FruitDto();
        fruitDtoTwo.setTransaction(TRANSACTION_TYPE_BUY);
        fruitDtoTwo.setFruitType(FRUIT_TYPE);
        fruitDtoTwo.setQuantity(QUANTITY_TWO);
        fruitDtoTwo.setDate(DATE_TWO);
        FruitDto fruitDtoThree = new FruitDto();
        fruitDtoThree.setTransaction(TRANSACTION_TYPE_RETURN);
        fruitDtoThree.setFruitType(FRUIT_TYPE);
        fruitDtoThree.setQuantity(QUANTITY_THREE);
        fruitDtoThree.setDate(DATE_ONE);
        fruitDtos.add(fruitDtoOne);
        fruitDtos.add(fruitDtoTwo);
        fruitDtos.add(fruitDtoThree);
        FruitStorage.clearStock();
    }

    @Test
    public void updateStock_correctWork() {
        fruitStorageUpdater.updateStock(fruitDtos);
        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
        int expectedSize = 1;
        int actualSize = fruits.size();
        Assert.assertEquals(expectedSize, actualSize);
    }
}
