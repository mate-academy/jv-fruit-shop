package core.basesyntax;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;

public class FruitStoreServiceTest {

    private FruitStoreService fruitStoreServiceTest;

    @Before
    public void setUp() throws Exception {
        fruitStoreServiceTest = new FruitStoreService();
    }

    @Test
    public void terminal_Ok() throws IOException {
        fruitStoreServiceTest.terminal("src/test/java/core/basesyntax/readWriteFile/foolTest/fileFrom.csv",
                "src/test/java/core/basesyntax/readWriteFile/foolTest/fileToActual.csv");

        List<String> expected = Files.readAllLines(Path.of("src/test/java/core/basesyntax/readWriteFile/foolTest/fileToExpected.csv"));
        List<String> actual = Files.readAllLines(Path.of("src/test/java/core/basesyntax/readWriteFile/foolTest/fileToActual.csv"));

        assertEquals(expected, actual);
    }
}