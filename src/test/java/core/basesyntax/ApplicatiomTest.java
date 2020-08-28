package core.basesyntax;

import core.basesyntax.Application;
import core.storageParser.FileService;
import core.storageParser.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


public class ApplicatiomTest {
    private static final FileService SERVICE = new FileServiceImpl();
    private static final String CORRECT_READ_FILE_PATH = "src/test/resources/fileServiceCorrect.csv";

    @Test
    public void checkGetListFromInputFileCorrect() {
        List<String> expected = List.of("s,banana,100,2020-09-11");
        SERVICE.setPath(CORRECT_READ_FILE_PATH);
        List<String> actual = SERVICE.readFile();
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals(expected, actual);
    }
}
