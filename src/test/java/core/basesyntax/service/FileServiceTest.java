package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FileServiceTest {
    public static final String FIRST_PATH = "src/test/java/resourses/test1.csv";
    public static final String SECOND_PATH = "src/test/java/resourses/test2.csv";
    public static final String THIRD_PATH = "src/test/java/resourses/WrongFormatTest.csv";
    public static final String FOURTH_PATH = "src/test/java/resourses/emptyFile.csv";
    FileService fileService = new FileService();

    @Test
    public void simpleWriteToFileTest() {
        double randomNumber = Math.random() * 1000;
        String actual = String.valueOf(randomNumber) + "\n";
        fileService.writeToFile(actual, "src/test/java/resourses/writeSomething.csv");
        try {
            List<String> result = Files
                    .readAllLines(Path.of("src/test/java/resourses/writeSomething.csv"));
            String expected = String.join("", result) + "\n";
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RuntimeException.class)
    public void writeByWrongPath() {
        fileService.writeToFile("", "randomfolder/tnmnmmn.csv");
    }

    @Test
    public void simpleReadFileTest() {
        String expected = "s,banana,100,2020-10-17";
        List<String> actual = fileService.readFile(FIRST_PATH);
        Assert.assertEquals(expected, actual.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderTestFail() {
        fileService.readFile("skorunkaZMaslom");
    }

    @Test
    public void fileReaderTestWithMultipleLines() {
        int actual = fileService.readFile(SECOND_PATH).size();
        Assert.assertEquals(4, actual);
    }

    @Test(expected = RuntimeException.class)
    public void emptyFileTest() {
        int actual = fileService.readFile(FOURTH_PATH).size();
    }

    @Test(expected = RuntimeException.class)
    public void wrongFileFormatTest() {
        int actual = fileService.readFile(THIRD_PATH).size();
    }
}
