package core.basesyntax.service.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Consumer;

@FunctionalInterface
public interface ActivityHandler extends Consumer<FruitTransaction> {
}
