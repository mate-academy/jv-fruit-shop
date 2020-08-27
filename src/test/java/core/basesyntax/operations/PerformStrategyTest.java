package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoSuchOperation;
import org.junit.Assert;
import org.junit.Test;

public class PerformStrategyTest {
    private static final String S_TYPE = "s";
    private static final String B_TYPE = "b";
    private static final String R_TYPE = "r";
    private static final String WRONG_TYPE = "a";
    private static final String WRONG_TYPE_EMPTY = "";
    private static final String WRONG_TYPE_NULL = null;
    private static final String WRONG_TYPE_SOME = "abc";

    @Test
    public void getSTypeStrategy() {
        Operable operation = PerformStrategy.getStrategy(S_TYPE);
        Assert.assertSame(operation.getClass(), Supplying.class);
    }

    @Test
    public void getBTypeStrategy() {
        Operable operation = PerformStrategy.getStrategy(B_TYPE);
        Assert.assertSame(operation.getClass(), Buying.class);
    }

    @Test
    public void getRTypeStrategy() {
        Operable operation = PerformStrategy.getStrategy(R_TYPE);
        Assert.assertSame(operation.getClass(), Returning.class);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeStrategy() {
        PerformStrategy.getStrategy(WRONG_TYPE);
    }

    @Test(expected = NoSuchOperation.class)
    public void getEmptyStrategy() {
        PerformStrategy.getStrategy(WRONG_TYPE_EMPTY);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeNullStrategy() {
        PerformStrategy.getStrategy(WRONG_TYPE_NULL);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeStrategySomeChars() {
        PerformStrategy.getStrategy(WRONG_TYPE_SOME);
    }
}
