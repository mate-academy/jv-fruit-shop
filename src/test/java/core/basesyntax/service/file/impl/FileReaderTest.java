package core.basesyntax.service.file.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.DataValidator;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderTest {
    private static DataValidator validator;
    private static DataReader reader;

    @BeforeClass
    public static void beforeClass() throws Exception {
        validator = new DataValidatorImpl();
        reader = new FileReader(validator);
    }

    @Test
    public void testName() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        assertEquals(expected, reader.readData("src/test/resources/data_for_FR.csv"));
    }
}
