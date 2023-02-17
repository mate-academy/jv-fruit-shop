package service;

import model.FruitTransaction;

import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final TransactionStrategy transactionStrategy;

    public ReportServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void createReport(List<FruitTransaction> transactions) {
        transactions.forEach(t -> transactionStrategy.get(t.getOperation())
                                            .apply(t.getFruit(), t.getAmount()));
    }
}
