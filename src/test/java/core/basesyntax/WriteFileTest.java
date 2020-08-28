package core.basesyntax;

import core.basesyntax.servise.FileWriteService;
import core.basesyntax.servise.WriteFile;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class WriteFileTest {
    private static FileWriteService fileWriteService;

    @BeforeClass
    public static void beforeClass() throws Exception {
        fileWriteService = new WriteFile();
        Storege.fruitStorage.clear();
    }

    @Test
    public void fileWriteWithEmptyMap() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("banana", 100);
        testMap.put("apple", 50);
        testMap.put("orange", 20);
        fileWriteService.writeToFile(testMap);
    }

    @Test(expected = NullPointerException.class)
    public void checkFileWriteWithNullArgument() {
        fileWriteService.writeToFile(null);
    }
}
