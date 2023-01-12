package core.basesyntax.service.transaction_operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionReportMaker {
    List<FruitTransaction> makeReport(FruitDao dao);
}
