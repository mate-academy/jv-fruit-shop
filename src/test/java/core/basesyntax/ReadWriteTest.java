package core.basesyntax;

import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.WriteToFile;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ReadWriteTest {
    private static String testPath = "src/test/resources/test";

    @Test
    public void readWriteTest_Ok() {
        WriteToFile fileWriter = new WriteToFileImpl();
        ReadFromFile fileReader = new ReadFromFileImpl();

        fileWriter.write(testPath, "fruit,quantity\n123\n456\n789");
        List<String> expected = List.of("123", "456", "789");
        List<String> actual = fileReader.readFromFile(testPath);

        Assert.assertEquals(expected, actual);
    }
}
