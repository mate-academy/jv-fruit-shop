package core.basesyntax;

import core.basesyntax.service.ConverterCsvToTransaction;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ConverterCsvToTransactionTest {
    private static ConverterCsvToTransaction converter = new ConverterCsvToTransaction();

    @Test
    public void convertOkTest() {
        Transaction transaction = new Transaction("s", "banana", 100,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));

        List<String> data = new ArrayList<>();
        data.add("s");
        data.add("banana");
        data.add("100");
        data.add("2020-10-17");

        Assert.assertEquals(transaction, converter.convert(data));
    }
}
