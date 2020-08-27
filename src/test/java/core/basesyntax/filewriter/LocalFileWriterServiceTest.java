package core.basesyntax.filewriter;

import core.basesyntax.exception.FileWritingException;
import core.basesyntax.model.InputDataModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class LocalFileWriterServiceTest {
    public static final String OUTPUT_FOLDER = "src/test/resources/output/";
    public static final String EXPECTED_FOLDER = "src/test/resources/expected/";
    private static FileWriterService localFileWriterService;
    private static Map<InputDataModel, Integer> inputMap;

    @BeforeClass
    public static void beforeClass() {
        localFileWriterService = new LocalFileWriterService();
        InputDataModel dataModel = new InputDataModel("banana", LocalDate.now());
        int amount = 10;
        inputMap = new LinkedHashMap<>();
        inputMap.put(dataModel, amount);
    }

    @Test
    public void writeFileOk() {
        String output = OUTPUT_FOLDER + "outputWriteFileOk.csv";
        String expected = EXPECTED_FOLDER + "expectedWriteFileOk.csv";
        localFileWriterService.writeFile(inputMap, output);
        try {
            Assert.assertEquals(Files.readAllLines(Paths.get(output)),
                    Files.readAllLines(Paths.get(expected)));
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test(expected = FileWritingException.class)
    public void invalidOutputPath() {
        String output = "src/test/resources/notExistingFolder/outputBuyExpiredFruit.csv";
        localFileWriterService.writeFile(inputMap, output);
    }
}
