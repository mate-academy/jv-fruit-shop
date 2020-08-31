package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OperationSupplyTest {
    private static final String SUPPLY = "s";
    private static List<List<String>> testValue;
    private static Operation supply;

    @BeforeClass
    public static void start() {
        supply = new OperationSupply();
        testValue = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add(SUPPLY);
        firstRow.add("pineapple");
        firstRow.add(String.valueOf(100));
        firstRow.add("2020-10-17");
        testValue.add(firstRow);
        List<String> secondRow = new ArrayList<>();
        secondRow.add(SUPPLY);
        secondRow.add("pineapple");
        secondRow.add(String.valueOf(13));
        secondRow.add("2020-10-15");
        testValue.add(secondRow);
        List<String> thirdRow = new ArrayList<>();
        thirdRow.add(SUPPLY);
        thirdRow.add("orange");
        thirdRow.add(String.valueOf(10));
        thirdRow.add("2020-10-17");
        testValue.add(thirdRow);
        List<String> fourthRow = new ArrayList<>();
        fourthRow.add(SUPPLY);
        fourthRow.add("orange");
        fourthRow.add(String.valueOf(50));
        fourthRow.add("2020-10-17");
        testValue.add(fourthRow);
    }

    @Test
    public void testSupplyOk() {
        int storageSize = FruitStorage.SUPPLY_FRUIT_BATCHES.size();
        SupplyFruitBatch currentBatch = new FruitParserImplementation().parse(testValue.get(0));
        supply.execute(currentBatch);
        currentBatch = new FruitParserImplementation().parse(testValue.get(1));
        supply.execute(currentBatch);
        Assert.assertEquals(storageSize + 2, FruitStorage.SUPPLY_FRUIT_BATCHES.size());
    }

    @Test
    public void testSupplySameEndOfShelfLife() {
        int storageSize = FruitStorage.SUPPLY_FRUIT_BATCHES.size();
        SupplyFruitBatch currentBatch = new FruitParserImplementation().parse(testValue.get(2));
        supply.execute(currentBatch);
        currentBatch = new FruitParserImplementation().parse(testValue.get(3));
        supply.execute(currentBatch);
        Assert.assertEquals(storageSize + 1, FruitStorage.SUPPLY_FRUIT_BATCHES.size());
    }
}
