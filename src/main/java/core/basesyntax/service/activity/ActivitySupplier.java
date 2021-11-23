package core.basesyntax.service.activity;

import core.basesyntax.service.activity.activityimpl.Balance;
import core.basesyntax.service.activity.activityimpl.Purchase;
import core.basesyntax.service.activity.activityimpl.Return;
import core.basesyntax.service.activity.activityimpl.Supply;

public class ActivitySupplier {
    public Activity getActivity(String activityAbbr, String fruitName, int amount) {
        switch (activityAbbr) {
            case "s": return new Supply(fruitName, amount);
            case "p": return new Purchase(fruitName, amount);
            case "r": return new Return(fruitName, amount);
            case "b": return new Balance(fruitName, amount);
            default: throw new RuntimeException("Invalid operation type");
        }
    }
}
