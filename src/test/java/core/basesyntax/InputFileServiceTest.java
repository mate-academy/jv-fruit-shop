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
        fileStrings.add(new ArrayList<>());
        fileStrings.add(new ArrayList<>());
        fileStrings.get(0).add("r");
        fileStrings.get(0).add("banana");
        fileStrings.get(0).add("100");
        fileStrings.get(0).add("2020-10-17");
        fileStrings.get(1).add("b");
        fileStrings.get(1).add("orange");
        fileStrings.get(1).add("13");
        fileStrings.get(1).add("2020-10-17");

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
