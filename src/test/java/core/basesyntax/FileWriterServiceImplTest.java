package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FileWriterServiceImplTest {
    private final FileReaderForTest fileReaderForTest = new FileReaderForTest();
    private final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final String FILE_PATH_TO_FILE_WE_WRITE_IN
            = "src/test/resources/writeFile";

    @Test(expected = RuntimeException.class)
    public void writeToBadNameFile() {
        Map<String, String> conclusionData = new HashMap<>();
        fileWriterService.writeToFile(conclusionData, "");
    }

    @Test
    public void toWriteInFile() {
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("apple", "4");
        expectedResult.put("lime", "23");
        fileWriterService.writeToFile(expectedResult, FILE_PATH_TO_FILE_WE_WRITE_IN);
        Assert.assertEquals(expectedResult.size(),
                fileReaderForTest.readWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .size());
        Assert.assertEquals(expectedResult.get("apple"),
                fileReaderForTest.readWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .get(0).get(1));
        Assert.assertEquals(expectedResult.get("lime"),
                fileReaderForTest.readWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .get(1).get(1));
    }
}
