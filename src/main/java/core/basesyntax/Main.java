package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.strategy.OperationContext;
import java.util.List;

public class Main {
    private static final String READ_FROM = "src/main/java/core/basesyntax/read.csv";
    private static final String WRITE_TO = "src/main/java/core/basesyntax/report.csv";

    public static void main(String[] args) {
        StorageRepository repository = new StorageRepository();
        FileService fileService = new FileServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        ReportService reportService = new ReportServiceImpl(repository);
        OperationContext operationContext = new OperationContext(repository);

        String lines = fileService.readFromFile(READ_FROM);
        List<Transaction> transactions = parseService.parse(lines);
        operationContext.executeStrategy(transactions);
        String report = reportService.generateReport();
        fileService.writeToFile(WRITE_TO, report);
    }
}
