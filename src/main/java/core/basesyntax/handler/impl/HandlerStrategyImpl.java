package core.basesyntax.handler.impl;

import core.basesyntax.exception.UnknownOperationException;
import core.basesyntax.handler.Balance;
import core.basesyntax.handler.HandlerStrategy;
import core.basesyntax.handler.Purchase;
import core.basesyntax.handler.Return;
import core.basesyntax.handler.Supply;
import java.util.HashMap;

public class HandlerStrategyImpl implements HandlerStrategy {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String RETIRNING = "r";
    private static final String PURCHASE = "p";
    private Balance balance = new BalanceImpl();
    private Supply supply = new SupplyImpl();
    private Return returning = new ReturnImpl();
    private Purchase purchase = new PurchaseImpl();

    @Override
    public void strategy(String[] info, HashMap<String, Integer> storage) {
        if (info[0].equals(BALANCE)) {
            balance.balance(info, storage);
        } else if (info[0].equals(SUPPLY)) {
            supply.supply(info, storage);
        } else if (info[0].equals(RETIRNING)) {
            returning.returning(info, storage);
        } else if (info[0].equals(PURCHASE)) {
            purchase.purchase(info,storage);
        } else {
            throw new UnknownOperationException("Wrong operation type");
        }
    }
}
