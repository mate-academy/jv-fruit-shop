package core.basesyntax.service.impl;

import core.basesyntax.service.StrategyChooser;
import core.basesyntax.strategу.MinusStrategy;
import core.basesyntax.strategу.PlusStrategy;
import core.basesyntax.strategу.Strategy;

public class StrategyChooserImpl implements StrategyChooser {

    @Override
    public Strategy getStrategy(String[] line) {
        String strategyLetter = line[0];
        if (strategyLetter.equals("s")
            || strategyLetter.equals("r")
            || strategyLetter.equals("b")) {
            return new PlusStrategy();
        } else if (strategyLetter.equals("p")){
            return new MinusStrategy();
        } else {
            throw new RuntimeException("got wrong commant to strategy");
        }
    }
}
