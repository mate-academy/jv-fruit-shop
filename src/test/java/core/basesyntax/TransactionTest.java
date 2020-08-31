package core.basesyntax;

import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionTest {
    private static Transaction transaction1 = new Transaction("s", "banana", 100,
            LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
    private static Transaction transaction2 = new Transaction("s", "banana", 100,
            LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));

    @Test
    public void TransactionEqualsOkTest() {
        Assert.assertTrue(transaction1.equals(transaction2));
    }

    @Test
    public void TransactionHashCodeOkTest() {
        Assert.assertEquals(transaction1.hashCode(), transaction2.hashCode());
    }
}
