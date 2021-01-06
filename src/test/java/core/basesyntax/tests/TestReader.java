package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.CsvFileReader;
import java.util.List;
import org.junit.Test;

public class TestReader {
    private static final String FILE_PATH_ONE_LINE =
            "src/test/java/core/basesyntax/tests/resourcestests/fruitShopOneLine.csv";
    private static final String FILE_PATH_FOUR_LINES =
            "src/test/java/core/basesyntax/tests/resourcestests/fruitShopFourLines.csv";
    private static final FileReader reader = new CsvFileReader();

    @Test
    public void checkReadOneLine() {
        List<String> dataFromFile = reader.readData(FILE_PATH_ONE_LINE);
        List<String> expected = List.of("type,fruit,quantity", "b,banana,20");
        assertEquals(dataFromFile.size(), expected.size(), "Size must be equal");
        assertEquals(expected, dataFromFile, "Data from file must be equal");
    }

    @Test
    public void checkReadFourLines() {
        List<String> dataFromFile = reader.readData(FILE_PATH_FOUR_LINES);
        List<String> expected = List.of("type,fruit,quantity", "b,banana,20",
                "r,banana,100", "s,banana,100", "p,banana,13");
        assertEquals(dataFromFile.size(), expected.size(), "Size must be equal");
        assertEquals(expected, dataFromFile, "Data from file must be equal");
    }

    @Test(expected = RuntimeException.class)
    public void notRightPath() {
        reader.readData("FILE_PATH_FOUR_LINES");
    }
}

