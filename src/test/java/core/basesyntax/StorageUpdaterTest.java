package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class StorageUpdaterTest {
    private static StorageUpdater newUpdate;
    private static final String PROPERLY_FILLED_FILE = "src\\test\\resources\\test11.csv";
    private static final String SECOND_PROPERLY_FILLED_FILE = "src\\test\\resources\\test6.csv";
    private static final String INCOMPLETE_DATA_FILE = "src\\test\\resources\\test10.csv";
    private static final String PURCHASE_FROM_EMPTY_STOCK_FILE = "src\\test\\resources\\test5.csv";
    private static Map<String, TreeMap<LocalDate, Integer>> toCompareEmptyStore = new HashMap<>();
    private static Map<String, TreeMap<LocalDate, Integer>> toCompareNotEmptyStore = new HashMap<>();

    static{
        toCompareEmptyStore.put("banana", new TreeMap<>());
        toCompareEmptyStore.put("apple", new TreeMap<>());
        toCompareEmptyStore.put("orange", new TreeMap<>());
        toCompareEmptyStore.get("banana").put(LocalDate.parse("2020-10-15"), 10);
        toCompareEmptyStore.get("banana").put(LocalDate.parse("2020-10-25"), 33);
        toCompareEmptyStore.get("orange").put(LocalDate.parse("2020-10-21"), 112);
        toCompareEmptyStore.get("apple").put(LocalDate.parse("2020-10-20"), 29);
        toCompareEmptyStore.get("apple").put(LocalDate.parse("2020-10-23"), 10);

        toCompareNotEmptyStore.put("banana", new TreeMap<>());
        toCompareNotEmptyStore.put("apple", new TreeMap<>());
        toCompareNotEmptyStore.put("orange", new TreeMap<>());
        toCompareNotEmptyStore.get("banana").put(LocalDate.parse("2020-10-15"), 10);
        toCompareNotEmptyStore.get("banana").put(LocalDate.parse("2020-10-17"), 100);
        toCompareNotEmptyStore.get("banana").put(LocalDate.parse("2020-10-25"), 33);
        toCompareNotEmptyStore.get("orange").put(LocalDate.parse("2020-10-21"), 129);
        toCompareNotEmptyStore.get("apple").put(LocalDate.parse("2020-10-20"), 29);
        toCompareNotEmptyStore.get("apple").put(LocalDate.parse("2020-10-22"), 15);
        toCompareNotEmptyStore.get("apple").put(LocalDate.parse("2020-10-23"), 10);
    }

    @Before
    public void setUp() {
        newUpdate = new StorageUpdaterImpl();
        Storage.clearStorage();
    }

    @Test
    public void updateStorageWhenFruitIsAbsent() throws IOException {
        LocalFileReader reader = new LocalFileReader(PURCHASE_FROM_EMPTY_STOCK_FILE);
        newUpdate.parseData(reader.readFromFile());
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllFruits();
        Map<String, TreeMap<LocalDate, Integer>> expectedResult = new HashMap<>();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmptyStorageFromFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(PROPERLY_FILLED_FILE);
        newUpdate.parseData(reader.readFromFile());
        Assert.assertEquals(toCompareEmptyStore, Storage.getAllFruits());
    }

    @Test
    public void updateNotEmptyStorageFromFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(PROPERLY_FILLED_FILE);
        newUpdate.parseData(reader.readFromFile());
        LocalFileReader secondFileReader = new LocalFileReader(SECOND_PROPERLY_FILLED_FILE);
        newUpdate.parseData(secondFileReader.readFromFile());
        Assert.assertEquals(toCompareNotEmptyStore, Storage.getAllFruits());
    }

    @Test
    public void getExceptionWhenDataIncomplete() throws IOException {
        LocalFileReader reader = new LocalFileReader(INCOMPLETE_DATA_FILE);
        try {
            newUpdate.parseData(reader.readFromFile());
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }
}
