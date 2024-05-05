package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDaoTransaction;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final FruitDaoTransaction fruitDao;

    public ReportServiceImpl(FruitDaoTransaction fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculateDataForReport(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            if (!fruitDao.getFruitMap().containsKey(fruitTransaction.getFruitName())) {
                fruitDao.getFruitMap()
                        .put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
            } else {
                fruitDao.updateAmount(fruitTransaction);
            }
        }
    }
}
