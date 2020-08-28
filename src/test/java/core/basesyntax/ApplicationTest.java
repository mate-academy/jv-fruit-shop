package core.basesyntax;

import core.storageParser.FileService;
import core.storageParser.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ApplicationTest {
    private static final FileService SERVICE = new FileServiceImpl();
    private static final String CORRECT_FILE_OUT = "Fruit In";

    @Test
    public void checkGetListFromInputFileCorrect() {
        List<String> expected = List.of("    s,banana,100,2020-10-17\n"
                ,"    b,banana,13,2020-10-15\n"
                ,"    r,banana,10,2020-10-17\n");
        SERVICE.setFileName(CORRECT_FILE_OUT);
        List<String> actual = SERVICE.readFile();
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }
}
