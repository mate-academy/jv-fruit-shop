package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Storage;
import core.basesyntax.service.ReadOperationFromFileService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;

public class DateTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String WRONG_DATE_PATH = "src/wrongDateTest.csv";
    private static final String EXPIRED_DATE_PATH = "src/expiredFruitsReturn.csv";

    @Before
    public void setup() {
        try {
            FileWriter fileWriter = new FileWriter(INTO_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Storage.storage.clear();
    }

    @Test
    public void dataParseExceptionTest() {
        try {
            ReadOperationFromFileService readFromFileService
                    = new ReadOperationFromFileService();
            readFromFileService.read(WRONG_DATE_PATH);

            Assert.fail("We had to get an exception");
        } catch (DateTimeParseException e) {
            String errMsg = "Text '20-10-2020' could not be parsed at index 0";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void expiredDateTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(EXPIRED_DATE_PATH);
            Assert.fail("We had to get an exception here");
        } catch (RuntimeException e) {
            String errMsg = "We can not accept this fruits!";
            assertEquals(errMsg, e.getMessage());
        }
    }
}
