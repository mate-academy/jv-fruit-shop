package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_SEPARATOR = ",";
    private final OperationStrategy strategy;
    private final CsvFileWriter writer;
    private final Storage storage;
    private final String header;

    public ReportServiceImpl(Storage storage, OperationStrategy strategy,
                             CsvFileWriter outputFile, String header) {
        this.storage = storage;
        this.strategy = strategy;
        this.header = header;
        this.writer = outputFile;
    }

    @Override
    public void getReport() {
        writer.write(getFormattedReport());
    }

    private List<String> getFormattedReport() {
        List<String> formattedList = new ArrayList<>();
        formattedList.add(header);
        getCalculation()
                .entrySet().stream()
                .map(e -> e.getKey() + COLUMN_SEPARATOR + e.getValue())
                .forEach(formattedList::add);
        return formattedList;
    }

    private Map<String, Integer> getCalculation() {
        return storage.getTransactions().stream()
                .collect(Collectors.groupingBy(Transaction::getProductName,
                        Collectors.summingInt(transaction ->
                                strategy.get(transaction.getOperationType())
                                        .getOperationResult(transaction.getQuantity()))));
    }
}
