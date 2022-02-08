package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.DataProcessorImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.amount.AdditionHandler;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.amount.SubtractionHandler;
import core.basesyntax.service.files.FileReaderImpl;
import core.basesyntax.service.files.ReportWriter;
import core.basesyntax.service.files.ReportWriterImpl;
import core.basesyntax.service.files.RowParser;
import core.basesyntax.service.files.RowParserImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/fruits_correct.csv";
    private static final String TARGET_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitRecord.Type, AmountHandler> strategies = new HashMap<>();
        strategies.put(FruitRecord.Type.BALANCE, new AdditionHandler());
        strategies.put(FruitRecord.Type.SUPPLY, new AdditionHandler());
        strategies.put(FruitRecord.Type.RETURN, new AdditionHandler());
        strategies.put(FruitRecord.Type.PURCHASE, new SubtractionHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        List<String> fileData = new FileReaderImpl().readFile(INPUT_FILE);
        RowParser rowParser = new RowParserImpl();
        List<FruitRecord> records = rowParser.parse(fileData);
        DataProcessor processor = new DataProcessorImpl();
        processor.processData(records);
        ReportCreator report = new ReportCreatorImpl(operationStrategy);
        ReportWriter newReportWriter = new ReportWriterImpl();
        List<String> newReport = report.createReport();
        newReportWriter.writeReportToFile(TARGET_FILE, newReport);
    }
}
