package core.basesyntax.strategy;

import core.basesyntax.model.FruitMovement;

public interface Strategy {
    PostingGoods getPostingAccordingMovement(FruitMovement movement);
}
