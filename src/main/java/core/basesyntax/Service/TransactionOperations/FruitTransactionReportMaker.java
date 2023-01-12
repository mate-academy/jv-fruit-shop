package core.basesyntax.Service.TransactionOperations;

import core.basesyntax.Dao.FruitDao;
import core.basesyntax.Model.FruitTransaction;
import java.util.List;

public interface FruitTransactionReportMaker {
    List<FruitTransaction> makeReport(FruitDao dao);
}
