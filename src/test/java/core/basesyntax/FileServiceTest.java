package core.basesyntax;

import core.basesyntax.servise.FileService;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileServiceTest {
    private static final FileService SERVICE = new FileService();
    private static final String FILE_SERVICE_REPORT = "src/test/resources/outputFile.csv";
    private static final String CORRECT_READ_FILE_PATH = "src/test/resources/fileServiceCorrect.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/emptyFile.csv";
    private static final String FILE_WITH_INCORRECT_TEXT_PATH = "src/test/resources/incorrectHead.csv";

    @Test
    public void checkGetListFromInputFileCorrect() {
        List<String> expected = List.of("s,banana,100,2020-10-17");
        List<String> actual = SERVICE
                .getListFromInputFile(CORRECT_READ_FILE_PATH);
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetListFromInputFileOnlyWithHead() {
        Assert.assertEquals(Collections.EMPTY_LIST,
                SERVICE.getListFromInputFile(FILE_WITH_INCORRECT_TEXT_PATH));
    }

    @Test(expected = RuntimeException.class)
    public void checkGetListFromInputFileWithIncorrectFilePath() {
        SERVICE.getListFromInputFile("incorrect.csv");
    }

    @Test
    public void checkCorrectWriteOutputFile() throws IOException {
        List<String> outputStrings = List.of("fruit,quantity", "banana,97");
        SERVICE.writeOutputFile(outputStrings, FILE_SERVICE_REPORT);
        Assert.assertTrue(Files.exists(Path.of(FILE_SERVICE_REPORT)));
        int size = 0;
        size = Files.readAllLines(Path.of(FILE_SERVICE_REPORT)).size();
        Assert.assertEquals(outputStrings.size(), size);
    }

    @Test(expected = RuntimeException.class)
    public void checkWriteOutputFileWithIncorrectFilePath() {
        SERVICE.writeOutputFile(List.of(""), "incorrect/incorrect");
    }

    @Test
    public void checkGetListFromEmptyFile() {
        Assert.assertEquals(Collections.EMPTY_LIST,
                SERVICE.getListFromInputFile(EMPTY_FILE_PATH));
    }
}