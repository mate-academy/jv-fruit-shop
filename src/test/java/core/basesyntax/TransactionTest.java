package core.basesyntax;

import core.basesyntax.operations.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class TransactionTest {

    static Transaction transaction = new Transaction("s","banana"
            , 25, LocalDate.of(2020,8,15));

    @Test
    public void testEquals() {
        Transaction transactionTheSame = new Transaction("s","banana"
                , 25,LocalDate.of(2020,8,15));
        Assert.assertEquals(true, transactionTheSame.equals(transaction));
    }

    @Test
    public void getTypeOfOperation() {
        Assert.assertEquals("s", transaction.getTypeOfOperation());
    }

    @Test
    public void getAmount() {
        Assert.assertEquals(25, transaction.getAmount());
    }

    @Test
    public void getExpirationDate() {
        Assert.assertEquals(LocalDate.of(2020,8,15), transaction.getExpirationDate());
    }

    @Test
    public void getTypeOfFruite() {
        Assert.assertEquals("banana", transaction.getTypeOfFruit());
    }
}
