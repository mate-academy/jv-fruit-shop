package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandlerFactory;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationHandlerFactory handlerFactory;

    public TransactionProcessorImpl(OperationHandlerFactory handlerFactory) {
        this.handlerFactory = handlerFactory;
    }

    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            handlerFactory.getHandler(transaction.getOperation())
                    .handle(transaction.getFruit().getName(), transaction.getQuantity());
        }
    }
}
