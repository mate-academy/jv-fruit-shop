package core.basesyntax;

import core.basesyntax.Fruit;
import core.basesyntax.Transaction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {

    static Transaction transaction = new Transaction("s","banana"
            , 25,"2020-08-15");

    @Test
    public void testEquals() {
        Transaction transactionTheSame = new Transaction("s","banana"
                , 25,"2020-08-15");
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
        Assert.assertEquals("2020-08-15", transaction.getExpirationDate());
    }

    @Test
    public void getTypeOfFruite() {
        Assert.assertEquals("banana", transaction.getTypeOfFruit());
    }
}