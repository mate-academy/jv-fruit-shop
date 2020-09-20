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
    private static final String CORRECT_FILE_IN = "src\\test\\resources\\fruitIn.csv";
    private static final String EMPTY_FILE_IN = "src\\test\\resources\\fruitEmpty.csv";
    private static final String NO_FILE = "src\\test\\resources\\404 File.csv";
    private static final String OUT_FILE = "src\\test\\resources\\fruitOut.csv";

    @Test
    public void checkReadFileOK() {
        List<String> expected = List.of("    s,banana,100,2020-10-17\n"
                ,"    b,banana,13,2020-10-15\n"
                ,"    r,banana,10,2020-10-17\n");
        List<String> actual = SERVICE.readFile(CORRECT_FILE_IN);
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FileEmptyException.class)
    public void checkReadEmptyFile() {
        SERVICE.readFile(EMPTY_FILE_IN);
    }

    @Test(expected = RuntimeException.class)
    public void checkNoFile() {
        SERVICE.readFile(NO_FILE);
    }

    @Test
    public void checkCorrectWriteOutputFile() throws IOException {
        List<String> outputStrings = List.of("fruit,quantity", "banana,97");
        SERVICE.writeFile(outputStrings, OUT_FILE);
        Assert.assertTrue(Files.exists(Path.of(OUT_FILE)));
        int size = Files.readAllLines(Path.of(OUT_FILE)).size();
        Assert.assertEquals(outputStrings.size(), size);
    }
}
