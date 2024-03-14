package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ReportGenerator {
    private ReaderService readerService;
    private WriterService writerService;
    private TransactionMapper transactionMapper;
    private NonNegativePredicate nonNegativePredicate;

    public ReportGenerator() {
        readerService = new CsvReaderService();
        transactionMapper = new TransactionMapper();
        writerService = new CsvWriterService();
        nonNegativePredicate = new NonNegativePredicate();
    }

    public void generateReport(String filePath, String reportName) {
        if (Files.exists(Paths.get(reportName + ".csv"))) {
            throw new RuntimeException("A file with this name already exists");
        }
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        readerService.readFromFile(filePath)
                .map(transactionMapper)
                .collect(Collectors.groupingBy(FruitTransaction::getFruitType,
                        Collectors.summingInt(FruitTransaction::getOperationValue)))
                .entrySet().stream()
                .filter(entry -> nonNegativePredicate.test(entry.getValue()))
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .forEach(entry -> builder.append(entry).append(System.lineSeparator()));

        writerService.writeReportToFile(builder.toString().trim(), reportName);
    }
}
