package core.basesyntax;

import core.exceptions.FileEmptyException;
import core.parser.FileService;
import core.parser.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileServiceTest {
    private static final FileService SERVICE = new FileServiceImpl();
    private static final String CORRECT_FILE_IN = "Fruit In";
    private static final String EMPTY_FILE_IN = "Fruit Empty";
    private static final String NO_FILE = "404 File";
    private static final String OUT_FILE = "FruitOut";

    @Test
    public void checkReadFileOK() {
        List<String> expected = List.of("    s,banana,100,2020-10-17\n"
                ,"    b,banana,13,2020-10-15\n"
                ,"    r,banana,10,2020-10-17\n");
        SERVICE.setFileName(CORRECT_FILE_IN);
        List<String> actual = SERVICE.readFile();
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FileEmptyException.class)
    public void checkReadEmptyFile() {
        SERVICE.setFileName(EMPTY_FILE_IN);
        SERVICE.readFile();
    }

    @Test(expected = RuntimeException.class)
    public void checkNoFile() {
        SERVICE.setFileName(NO_FILE);
        SERVICE.readFile();
    }

    @Test
    public void checkCorrectWriteOutputFile() throws IOException {
        List<String> outputStrings = List.of("fruit,quantity", "banana,97");
        SERVICE.writeFile(outputStrings, OUT_FILE);
        Assert.assertTrue(Files.exists(Path.of(SERVICE.getPath())));
        int size = Files.readAllLines(Path.of(SERVICE.getPath())).size();
        Assert.assertEquals(outputStrings.size(), size);
    }
}
