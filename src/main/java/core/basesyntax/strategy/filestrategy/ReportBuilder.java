package core.basesyntax.strategy.filestrategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportBuilder {
    String buildReport(List<FruitTransaction> transactions);
}
