package core.basesyntax.utils.convert;

import core.basesyntax.utils.transaction.FruitTransaction;
import java.util.List;

public interface ReportConverter {
    List<FruitTransaction> convert();
}
