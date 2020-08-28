package core.basesyntax.readwritefile;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WriteCSVTest {

    private WriteCsv testWriter;

    @Before
    public void setUp() throws Exception {
        testWriter = new WriteCsv();
    }

    @Test
    public void writeCSV_Ok() throws IOException {
        Map<String, Integer> currentBalance = new HashMap<>();
        currentBalance.put("banana", 97);
        testWriter.writeCsv(currentBalance,"src/test/java/core/basesyntax/readWriteFile/testFilesToWrite/FileOkActual.csv");

        List<String> expected = Files.readAllLines(Path.of("src/test/java/core/basesyntax/readWriteFile/testFilesToWrite/FileOkExpected.csv"));
        List<String> actual = Files.readAllLines(Path.of("src/test/java/core/basesyntax/readWriteFile/testFilesToWrite/FileOkActual.csv"));
        assertEquals(expected,actual);
    }
}
