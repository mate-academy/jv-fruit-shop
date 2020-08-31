package core.basesyntax;

import core.basesyntax.service.ConverterCsvToTransactions;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConverterCsvToTransactionTest {
    private static ConverterCsvToTransactions converter = new ConverterCsvToTransactions();

    @Test
    public void convertOkTest() {
        Transaction transaction1 = new Transaction("s", "banana", 100,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        Transaction transaction2 = new Transaction("b", "orange", 15,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        List<Transaction> expectedTransactionsList = new ArrayList<>();
        expectedTransactionsList.add(transaction1);
        expectedTransactionsList.add(transaction2);

        List<List<String>> fileStrings = new ArrayList<>();
        fileStrings.add(List.of("s", "banana", "100", "2020-10-17"));
        fileStrings.add(List.of("b", "orange", "15", "2020-10-17"));

        Assert.assertEquals(expectedTransactionsList, converter.convert(fileStrings));
    }
}
