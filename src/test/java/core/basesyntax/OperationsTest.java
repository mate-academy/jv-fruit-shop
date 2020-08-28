package core.basesyntax;

import core.basesyntax.service.impl.InputFileServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperationsTest {
    private static Storage storage = new Storage();
    private static InputFileServiceImpl inputFileService = new InputFileServiceImpl();

    @Test
    public void supplyOperationOkTest() {
        for (int i = 0; i < 100; i++) {
            storage.addFruit(new Fruit("banana",
                    LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        Transaction transaction = new Transaction("s", "banana", 100,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));

        Assert.assertEquals(storage.getStorage().size(), 100);
    }
}
