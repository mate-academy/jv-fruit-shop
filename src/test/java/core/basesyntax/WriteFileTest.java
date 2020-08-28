package core.basesyntax;

import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.WriteFileServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WriteFileTest {
    private static WriteFileService fileWriteService;

    @BeforeClass
    public static void BeforeClass() {
        fileWriteService = new WriteFileServiceImpl();
    }

    @Test
    public void fileWriteWithEmptyMap() {
        Map<String, Integer> testMap = new HashMap<>();
        fileWriteService.writeFile(testMap);
    }

    @Test(expected = NullPointerException.class)
    public void checkFileWriteWithNullArgument() {
        fileWriteService.writeFile(null);
    }
}
