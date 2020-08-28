package core.basesyntax.resources;

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
}