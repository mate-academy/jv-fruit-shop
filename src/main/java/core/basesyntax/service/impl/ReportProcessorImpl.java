package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReportProcessor;
import core.basesyntax.strategy.BiFunctionSupplier;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

public class ReportProcessorImpl implements ReportProcessor<String> {
    private static final String DELIMITER = ",";
    private final Map<Fruit, List<Transaction>> transactionsData;
    private String header;

    private ReportProcessorImpl(Map<Fruit, List<Transaction>> transactionsData, String header) {
        this.transactionsData = transactionsData;
        this.header = header;
    }

    public static ReportProcessorImpl of(Map<Fruit,
            List<Transaction>> transactionsData, String header) {
        return new ReportProcessorImpl(transactionsData, header);
    }

    @Override
    public String getReport() {
        return transactionsData.entrySet().stream()
                .map(e -> e.getKey().getName() + DELIMITER
                        + getReportForOneFruit(e.getValue()))
                .collect(Collectors.joining(System.lineSeparator(),
                        header + System.lineSeparator(), ""));
    }

    private int getReportForOneFruit(List<Transaction> transactionList) {
        int result = 0;
        ToIntBiFunction<Integer, Integer> biFunction;
        BiFunctionSupplier biFunctionSupplier = new BiFunctionSupplier();
        for (Transaction t : transactionList) {
            biFunction = biFunctionSupplier.getFunction(t.getOperation());
            result = biFunction.applyAsInt(result, t.getQuantity());
        }
        if (result < 0) {
            throw new RuntimeException("Something went wrong... The result for "
                    + transactionList.get(0).getFruit().getName()
                    + " is " + result);
        }
        return result;
    }
}
