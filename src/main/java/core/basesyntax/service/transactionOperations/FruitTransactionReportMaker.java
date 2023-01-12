package core.basesyntax.service.transactionOperations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionReportMaker {
    List<FruitTransaction> makeReport(FruitDao dao);
}
