package core.basesyntax;

import core.basesyntax.model.OperationModel;
import core.basesyntax.service.FileParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.service.impl.FileParserImpl;
import core.basesyntax.service.service.impl.FileReaderImpl;
import core.basesyntax.service.service.impl.FileWriterImpl;
import core.basesyntax.service.service.impl.ReportWriterImpl;
import core.basesyntax.service.strategy.TransactionStrategy;
import core.basesyntax.service.strategy.TransactionStrategyImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final Path startPath = Paths.get("src/main/resources/inputOperation.txt");
    private static final LocalDate localDate = LocalDate.now();
    private static final Path endPath = Paths.get("src/main/resources/dailyRecord_"
            + localDate + ".txt");

    public static void main(String[] args) {
        FileReaderService reader = new FileReaderImpl();
        List<String> listFromFile = reader.readFromFile(startPath);

        FileParserService parser = new FileParserImpl();
        List<OperationModel> convertData = parser.parse(listFromFile);

        TransactionStrategy strategy = new TransactionStrategyImpl();
        strategy.transactionOperator(convertData);

        ReportWriter reportWriter = new ReportWriterImpl();
        String dailyReport = reportWriter.createReport();

        FileWriterService writeToFile = new FileWriterImpl();
        writeToFile.writeToFile(dailyReport, endPath);
    }
}
