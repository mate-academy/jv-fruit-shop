package core.basesyntax.strategy;

import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;
import core.basesyntax.strategy.impl.RefundFruitQuantity;
import core.basesyntax.strategy.impl.ResupplyFruitQuantity;
import core.basesyntax.strategy.impl.SellFruitQuantity;
import core.basesyntax.strategy.impl.StartingFruitQuantity;

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
