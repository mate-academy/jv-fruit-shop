package core.basesyntax.service.strategy;

import core.basesyntax.model.Item_Operation;
import core.basesyntax.service.strategy.impl.RefundFruitQuantity;
import core.basesyntax.service.strategy.impl.ResupplyFruitQuantity;
import core.basesyntax.service.strategy.impl.SellFruitQuantity;
import core.basesyntax.service.strategy.impl.StartingFruitQuantity;

public class StrategyChooseFruit {
    public FruitQuantityChange getOptionFruitQuantityChange (Item_Operation operation) {
        switch (operation) {
            case BALANCE:
                return new StartingFruitQuantity();
            case SUPPLY:
                return new ResupplyFruitQuantity();
            case PURCHASE:
                return new SellFruitQuantity();
            case RETURN:
                return new RefundFruitQuantity();
        }
    }
}
