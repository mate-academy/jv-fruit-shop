package core.basesyntax.shopservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final FruitsDao dao;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.dao = new FruitsDaoImpl();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(transaction -> {
                    Operation op = transaction.getOperation();
                    OperationHandler handler = strategy.getTransactionHandler(op);
                    handler.setDao(dao);
                    handler.updateData(transaction);
                });

    }

    public ReportGenerator getRaportGenerator() {
        return new ReportGeneratorImpl(dao.getStorage());
    }
}
