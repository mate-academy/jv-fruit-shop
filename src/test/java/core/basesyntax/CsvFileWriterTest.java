package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileWriterTest {
    private static CsvFileWriter writer;
    private static CsvFileReader reader;
    private static FruitStorage storage;

    @BeforeClass
    public static void BeforeClass() {
        writer = new CsvFileWriter();
        reader = new CsvFileReader();
        storage = new FruitStorage();
    }
    @Test
    public void normalTest() throws IOException {
        writer.write("src/main/resources/test.csv", storage.createFruitStorage(reader.readFile("src/main/resources/NormalInput.csv")));
        List<String> expected = Files.readAllLines(Paths.get("src/main/resources/test.csv"));
        List<String> actual = Files.readAllLines(Paths.get("src/main/resources/NormalOutput.csv"));
        Assert.assertEquals(expected, actual);
    }
}
