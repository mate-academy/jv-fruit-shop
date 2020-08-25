package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class UpdateStorageTest {
    private static UpdateStorage newUpdate;
    private static final String PROPERLY_FILLED_FILE = "test11.csv";
    private static final String INCOMPLETE_DATA_FILE = "test10.csv";
    private static HashMap<String, TreeMap<LocalDate, Integer>> toCompareEmptyStore = new HashMap<>();
    private static HashMap<String, TreeMap<LocalDate, Integer>> toCompareNotEmptyStore = new HashMap<>();

    @BeforeClass
    public static void setUp() {
        newUpdate = new UpdateStorageImpl();
        Storage.fruitsInStore = new HashMap<>();

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
        toCompareNotEmptyStore.get("banana").put(LocalDate.parse("2020-10-17"), 4);
        toCompareNotEmptyStore.get("banana").put(LocalDate.parse("2020-10-25"), 53);
        toCompareNotEmptyStore.get("orange").put(LocalDate.parse("2020-10-21"), 224);
        toCompareNotEmptyStore.get("apple").put(LocalDate.parse("2020-10-20"), 58);
        toCompareNotEmptyStore.get("apple").put(LocalDate.parse("2020-10-23"), 20);
    }

    @Test
    public void updateEmptyStorageFromFile() throws IOException {
        newUpdate.parseFileToStorage(PROPERLY_FILLED_FILE);
        Assert.assertEquals(toCompareEmptyStore, Storage.fruitsInStore);
    }

    @Test
    public void updateNotEmptyStorageFromFile() throws IOException {
        newUpdate.parseFileToStorage(PROPERLY_FILLED_FILE);
        Assert.assertEquals(toCompareNotEmptyStore, Storage.fruitsInStore);
    }

    @Test
    public void getExceptionWhenDataIncomplete() throws IOException {
        try {
            newUpdate.parseFileToStorage(INCOMPLETE_DATA_FILE);
        } catch (ArrayIndexOutOfBoundsException message) {
            return;
        }
        Assert.fail("ArrayIndexOutOfBoundsException should be thrown");
    }
}
