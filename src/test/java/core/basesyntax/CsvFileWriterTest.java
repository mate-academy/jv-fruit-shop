package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileWriterTest {
    CsvFileWriter writer = new CsvFileWriter();
    CsvFileReader reader = new CsvFileReader();
    FruitStorage storage = new FruitStorage();

    @Test
    public void normalTest() throws IOException {
        writer.write("src/main/resources/test.csv", storage.fruitStorage(reader.readFile("src/main/resources/NormalInput.csv")));
        List<String> file1 = Files.readAllLines(Paths.get("src/main/resources/test.csv"));
        List<String> file2 = Files.readAllLines(Paths.get("src/main/resources/NormalOutput.csv"));
        Assert.assertEquals(file1, file2);
    }
}
