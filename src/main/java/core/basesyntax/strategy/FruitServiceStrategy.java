package core.basesyntax.strategy;

import core.basesyntax.Operations;
import core.basesyntax.service.ChangeFruitQuantityService;
import core.basesyntax.service.imp.AddFruitService;
import core.basesyntax.service.imp.SetFruitBalance;
import core.basesyntax.service.imp.SubtractFruitService;

public class FruitServiceStrategy {
    public ChangeFruitQuantityService chooseFruitService(Operations operation) {
        switch (operation) {
            case RETURN:
            case SUPPLY:
                return new AddFruitService();
            case PURCHASE:
                return new SubtractFruitService();
            case BALANCE:
            default:
                return new SetFruitBalance();
        }
    }
}
