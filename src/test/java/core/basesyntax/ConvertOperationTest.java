package core.basesyntax;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.model.Operation;
import org.junit.Assert;
import org.junit.Test;

public class ConvertOperationTest {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String EMPTY = "";
    private static final String WRONG = "q";
    private static ConvertOperation convertOperation = new ConvertOperation();

    @Test
    public void convertTest_ok() {
        Operation operationSupply = (Operation) convertOperation.convert(SUPPLY);
        Operation operationBuy = (Operation) convertOperation.convert(BUY);
        Operation operationReturn = (Operation) convertOperation.convert(RETURN);
        Assert.assertEquals(Operation.SUPPLY, operationSupply);
        Assert.assertEquals(Operation.BUY, operationBuy);
        Assert.assertEquals(Operation.RETURN, operationReturn);
    }

    @Test
    public void convertTest_exception() {
        Operation operation;
        try {
            operation = (Operation) convertOperation.convert(EMPTY);
            Assert.fail("Expect CsvFileException class");
        } catch (CsvFileException e) {
            Assert.assertEquals("File contains wrong operation format", e.getMessage());
        }
        try {
            operation = (Operation) convertOperation.convert(WRONG);
            Assert.fail("Expect CsvFileException class");
        } catch (CsvFileException e) {
            Assert.assertEquals("File contains wrong operation format", e.getMessage());
        }
    }
}
