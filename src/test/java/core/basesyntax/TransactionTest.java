package core.basesyntax;

import core.basesyntax.fruitservice.Transaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransactionTest {
    private static final String EXPECTED_OPERATION = "b";
    private static final String EXPECTED_PRODUCT = "banana";
    private static final int EXPECTED_QUANTITY = 200;
    private static final LocalDate EXPECTED_DATE = LocalDate.parse("2010-11-20");
    private static final String OPERATION = "b";
    private static final String PRODUCT = "banana";
    private static final int QUANTITY = 200;
    private static final LocalDate DATE = LocalDate.parse("2010-11-20");

    @Test
    public void constructorTest() {
        Transaction transaction1 = new Transaction("b", "banana", "150", "2020-12-23");
        Transaction transaction2 = new Transaction("b", "banana", "150", "2020-12-23");
        Assert.assertEquals(transaction1, transaction2);
    }

    @Test
    public void testOfEqualsMethod() {
        Transaction transaction1 = new Transaction("b", "banana", "200", "2010-11-20");
        Transaction transaction2 = new Transaction("b", "banana", "200", "2010-11-20");
        Assert.assertTrue(transaction1.equals(transaction2));
    }

    @Test
    public void gettersTest() {
        Transaction transaction = new Transaction(OPERATION, PRODUCT, "200", "2010-11-20");
        Assert.assertEquals(EXPECTED_OPERATION, transaction.getOperation());
        Assert.assertEquals(EXPECTED_PRODUCT, transaction.getProduct());
        Assert.assertEquals(EXPECTED_QUANTITY, transaction.getQuantity());
        Assert.assertEquals(EXPECTED_DATE, transaction.getDate());
    }

    @Test
    public void settersTest() {
        Transaction transaction = new Transaction();
        transaction.setOperation(OPERATION);
        transaction.setProduct(PRODUCT);
        transaction.setQuantity(QUANTITY);
        transaction.setDate(DATE);
        Assert.assertEquals(EXPECTED_OPERATION, transaction.getOperation());
        Assert.assertEquals(EXPECTED_PRODUCT, transaction.getProduct());
        Assert.assertEquals(EXPECTED_QUANTITY, transaction.getQuantity());
        Assert.assertEquals(EXPECTED_DATE, transaction.getDate());
    }
}