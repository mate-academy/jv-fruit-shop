package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoSuchOperation;
import org.junit.Assert;
import org.junit.Test;

public class StrategyPerformerTest {
    private static final String S_TYPE = "s";
    private static final String B_TYPE = "b";
    private static final String R_TYPE = "r";
    private static final String WRONG_TYPE = "a";
    private static final String WRONG_TYPE_EMPTY = "";
    private static final String WRONG_TYPE_NULL = null;
    private static final String WRONG_TYPE_SOME = "abc";
    private final StrategyPerformer strategyPerformer = new StrategyPerformer();

    @Test
    public void getSTypeStrategy() {
        Operable operation = strategyPerformer.getStrategy(S_TYPE);
        Assert.assertSame(operation.getClass(), Supplying.class);
    }

    @Test
    public void getBTypeStrategy() {
        Operable operation = strategyPerformer.getStrategy(B_TYPE);
        Assert.assertSame(operation.getClass(), Buying.class);
    }

    @Test
    public void getRTypeStrategy() {
        Operable operation = strategyPerformer.getStrategy(R_TYPE);
        Assert.assertSame(operation.getClass(), Returning.class);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeStrategy() {
        strategyPerformer.getStrategy(WRONG_TYPE);
    }

    @Test(expected = NoSuchOperation.class)
    public void getEmptyStrategy() {
        strategyPerformer.getStrategy(WRONG_TYPE_EMPTY);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeNullStrategy() {
        strategyPerformer.getStrategy(WRONG_TYPE_NULL);
    }

    @Test(expected = NoSuchOperation.class)
    public void getWrongTypeStrategySomeChars() {
        strategyPerformer.getStrategy(WRONG_TYPE_SOME);
    }
}
