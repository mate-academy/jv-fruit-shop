package service.ipml;

import model.FruitTransaction;
import service.ReportService;
import service.operation.OperationsHandler;

import java.util.List;

public class TransactionsActivitiesServiceImpl implements ReportService {
    @Override
    public void activityOfTransaction(List<FruitTransaction> transactions) {
        private final OperationStrategy operationStrategy;

    public TransactionsActivitiesServiceImpl(OperationOption operationStrategy) {
            this.operationStrategy = (OperationStrategy) operationStrategy;
        }

        @Override
        public void activityOfTransaction(List<FruitTransaction> transactions) {
            transactions.forEach(transaction -> {
                OperationsHandler operationHandler = operationStrategy.getHandler(transaction);
                operationHandler.handler(transaction);
            });
        }
    }

}
}
