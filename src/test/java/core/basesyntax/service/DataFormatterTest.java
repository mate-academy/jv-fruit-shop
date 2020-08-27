package core.basesyntax.service;

import core.basesyntax.model.FruitBatch;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DataFormatterTest {
    DataFormatter dataFormatter = new DataFormatter();
    private static Map<FruitBatch, Integer> data = new HashMap<>();
    private static String FRUIT_TYPE_ONE = "banana";
    private static String FRUIT_TYPE_TWO = "pomegranate";
    private static int QUANTITY_ONE = 12;
    private static int QUANTITY_TWO = 111;
    private static final LocalDate EXPIRY_DATE_ONE = LocalDate.of(2020, 11, 12);
    private static final LocalDate EXPIRY_DATE_TWO = LocalDate.of(2020,11, 13);

    @BeforeClass
    public static void setUp() {
        FruitBatch fruitBatchOne = new FruitBatch(FRUIT_TYPE_ONE, EXPIRY_DATE_ONE);
        FruitBatch fruitBatchTwo = new FruitBatch(FRUIT_TYPE_TWO, EXPIRY_DATE_TWO);
        data.put(fruitBatchOne, QUANTITY_ONE);
        data.put(fruitBatchTwo, QUANTITY_TWO);
    }

    @Test
    public void formatData_correctWork() {
        Map<String, Integer> actualResult = dataFormatter.formatData(data);
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put(FRUIT_TYPE_ONE, QUANTITY_ONE);
        expectedResult.put(FRUIT_TYPE_TWO, QUANTITY_TWO);
        Assert.assertEquals(expectedResult, actualResult);
    }






}