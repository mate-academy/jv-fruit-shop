package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.DataProcessorImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.amount.AddAmount;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.amount.SubtractAmount;
import core.basesyntax.service.files.InputFileReaderImpl;
import core.basesyntax.service.files.InputRowParser;
import core.basesyntax.service.files.InputRowParserImpl;
import core.basesyntax.service.files.ReportWriter;
import core.basesyntax.service.files.ReportWriterImpl;
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
        strategies.put(FruitRecord.Type.BALANCE, new AddAmount());
        strategies.put(FruitRecord.Type.SUPPLY, new AddAmount());
        strategies.put(FruitRecord.Type.RETURN, new AddAmount());
        strategies.put(FruitRecord.Type.PURCHASE, new SubtractAmount());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        List<String> fileData = new InputFileReaderImpl().readFile(INPUT_FILE);
        InputRowParser inputRowParser = new InputRowParserImpl();
        List<FruitRecord> records = inputRowParser.parse(fileData);
        DataProcessor processor = new DataProcessorImpl();
        processor.processData(records);
        ReportCreator report = new ReportCreatorImpl(operationStrategy);
        ReportWriter newReportWriter = new ReportWriterImpl();
        List<String> newReport = report.createReport();
        newReportWriter.writeReportToFile(TARGET_FILE, newReport);
    }
}
