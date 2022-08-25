package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.strategy.PostingGoods;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.PostingBalanceOfFruits;
import core.basesyntax.strategy.impl.PostingPurchaseOfFruit;
import core.basesyntax.strategy.impl.PostingReturnOfFruit;
import core.basesyntax.strategy.impl.PostingSupplyOfFruit;

public class PostingStrategy implements Strategy {
    public PostingGoods getPostingAccordingMovement(FruitMovement movement) {
        switch (movement.getType()) {
            case BALANCE:
                return new PostingBalanceOfFruits();
            case SUPPLY:
                return new PostingSupplyOfFruit();
            case PURCHASE:
                return new PostingPurchaseOfFruit();
            case RETURN:
            default:
                return new PostingReturnOfFruit();
        }
    }
}
