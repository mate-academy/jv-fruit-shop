package core.basesyntax;

import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.interfaces.ReadFromFile;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
    private static String resultPath = "src/test/resources/result";
    private static ReadFromFile fileReader;

    @BeforeClass
    public static void setUp() {
        fileReader = new ReadFromFileImpl();
    }

    @Test
    public void ususalTest_Ok() {
        Main.main(new String[]{});

        List<String> expected = List.of("banana,152", "apple,90");
        List<String> actual = fileReader.readFromFile(resultPath);

        Assert.assertEquals(expected, actual);
    }
}
