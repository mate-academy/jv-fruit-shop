package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.action.ActionHandler;
import java.util.Queue;
import java.util.stream.Collectors;

public class ProcessorServiceImpl implements ProcessorService {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String REPORT_SEPARATOR = ",";

    private final ActionStrategy actionStrategy;
    private final ProductDao productDao;

    public ProcessorServiceImpl(ActionStrategy actionStrategy, ProductDao productDao) {
        this.actionStrategy = actionStrategy;
        this.productDao = productDao;
    }

    @Override
    public void processing(Queue<ProductTransaction> productTransactions) {
        while (!productTransactions.isEmpty()) {
            ProductTransaction productTransaction = productTransactions.poll();
            ActionHandler actionHandler = actionStrategy.get(productTransaction.getOperation());
            actionHandler.runAction(productDao, productTransaction);
        }
    }

    @Override
    public String report() {
        return productDao.getAll().stream()
                .map(p -> p.getName() + REPORT_SEPARATOR + p.getQuantity())
                .collect(Collectors.joining(System.lineSeparator(), REPORT_HEADER, ""));
    }
}
