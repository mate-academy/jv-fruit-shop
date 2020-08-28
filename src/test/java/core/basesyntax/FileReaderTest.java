package core.basesyntax;

import core.basesyntax.service.FileReadService;
import core.basesyntax.service.impl.FileReadServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FileReaderTest {
    private static final String FILE_NAME_OK = "src/test/resources/fileReaderTest.txt";
    private static final String EMPTY_FILE = "src/test/resources/emptyFile.txt";
    private static final String WRONG_NAME_FILE = "wrongName.txt";

    private static final FileReadService fileReadService = new FileReadServiceImpl();

    @Test
    public void fileReadOk() {
        List<Transaction> actual = fileReadService.readFile(FILE_NAME_OK);

        Assert.assertEquals(3, actual.size());
        Assert.assertEquals("s", actual.get(0).getAction());
        Assert.assertEquals("banana", actual.get(0).getFruit());
        Assert.assertEquals("100", actual.get(0).getQuantity());
    }

    @Test
    public void readEmpty() {
        try {
            fileReadService.readFile(EMPTY_FILE);
        } catch (RuntimeException e) {
            Assert.assertEquals("File is empty", e.getMessage());
            return;
        }
        Assert.fail();
    }


    @Test
    public void wrongName() {
        try {
            fileReadService.readFile(WRONG_NAME_FILE);
        } catch (RuntimeException e) {
            Assert.assertEquals("File is not exist", e.getLocalizedMessage());
            return;
        }
        Assert.fail();
    }
}
