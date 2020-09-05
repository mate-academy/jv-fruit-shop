package core.basesyntax;

import core.basesyntax.operations.FileReaderImpl;
import org.junit.Assert;
import org.junit.Test;

public class ReadFromFileTest {
    private static final String FIRST_FILE_NAME = "src/test/resources/txt1.csv";
    public final static String FIRST_INPUT_DATA = "type,fruit,quantity,date";

    @Test
    public void text_Reader_Test_OK() {
        FileReaderImpl reader = new FileReaderImpl();
        String actual = reader.readFromFile(FIRST_FILE_NAME).get(0);
        Assert.assertEquals(FIRST_INPUT_DATA, actual);
    }

    @Test(expected = RuntimeException.class)
    public void text_Reader_Test_Fail() {
        FileReaderImpl reader = new FileReaderImpl();
        reader.readFromFile("incorrect file name").get(0);
    }
}
