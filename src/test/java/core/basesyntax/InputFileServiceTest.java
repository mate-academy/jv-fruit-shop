package core.basesyntax;

import core.basesyntax.service.impl.InputFileServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class InputFileServiceTest {
    private static InputFileServiceImpl inputFileService = new InputFileServiceImpl();
    public static final String TXT_FILE = "src/main/resources/test.txt";
    public static final String FILE_OK = "src/main/resources/testOK.csv";
    public static final String FILE_WRONG_DATA = "src/main/resources/testWrongData.csv";

    @Test (expected = RuntimeException.class)
    public void readFileTxtTest(){
        inputFileService.readFile(TXT_FILE);
    }

    @Test
    public void readFileOkTest() {
        List<List<String>> fileStrings = new ArrayList<>();
        fileStrings.add(List.of("r", "banana", "100", "2020-10-17"));
        fileStrings.add(List.of("b", "orange", "13", "2020-10-17"));

        Assert.assertEquals(fileStrings, inputFileService.readFile(FILE_OK));
    }

    @Test (expected = RuntimeException.class)
    public void readFileWrongDataTest() {
        inputFileService.readFile(FILE_WRONG_DATA);
    }

    @Test (expected = RuntimeException.class)
    public void noFileTest() {
        inputFileService.readFile("someFile.csv");
    }
}
