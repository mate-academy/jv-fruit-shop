package core.basesyntax;

import core.basesyntax.service.FruitFileReader;
import core.basesyntax.service.FruitFileWriter;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitFileWriterTest {
    private FruitFileWriter writer = new FruitFileWriter();
    FruitFileReader reader = new FruitFileReader();
    private Storage storage = new Storage();

    @Before
    public void setUp() {
        List<Operation> list = reader.readOperation("src/PerfectData.csv");
        storage.addFruits(list);
    }

    @Test
    public void testResult() throws IOException {
        writer.writeFruits(storage.getAllInfo(), "src/OutputFile.csv");
        List<String> expected = Files.readAllLines(Path.of("src/PerfectResult.csv"));
        List<String> actual = Files.readAllLines(Path.of("src/OutputFile.csv"));
        Assert.assertEquals(expected, actual);
    }
}
