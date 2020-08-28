package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitFileWriterTest {
    private final FruitFileWriter writer = new FruitFileWriter();
    FruitFileReader reader = new FruitFileReader();
    private final FruitStorage fruitStorage = new FruitStorage();

    @Before
    public void setUp() {
        List<FruitOperation> list = reader.readOperation("src/main/resources/Input.csv");
        fruitStorage.add(list);
    }

    @Test
    public void testResult() throws IOException {
        writer.writeFruits(fruitStorage.getInfo(), "src/main/resources/Output.csv");
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/Result.csv"));
        List<String> actual = Files.readAllLines(Path.of("src/main/resources/Output.csv"));
        Assert.assertEquals(expected, actual);
    }
}
