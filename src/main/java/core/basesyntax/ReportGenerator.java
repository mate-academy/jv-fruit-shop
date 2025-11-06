package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public abstract class ReportGenerator {
    public abstract String generate(List<FruitTransaction> data);
}
