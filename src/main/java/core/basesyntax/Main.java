package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.Worker;
import core.basesyntax.service.WorkerImpl;
import core.basesyntax.service.amount.AddAmount;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.amount.SubtractAmount;
import core.basesyntax.service.files.*;
import core.basesyntax.service.strategy.AmountStrategy;
import core.basesyntax.service.strategy.AmountStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/fruits_correct.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitRecord.Type, AmountHandler> strategies = new HashMap<>();
        strategies.put(FruitRecord.Type.BALANCE, new AddAmount());
        strategies.put(FruitRecord.Type.SUPPLY, new AddAmount());
        strategies.put(FruitRecord.Type.RETURN, new AddAmount());
        strategies.put(FruitRecord.Type.PURCHASE, new SubtractAmount());
        AmountStrategy amountStrategy = new AmountStrategyImpl(strategies);
        List<String> fileData = new InputFileReaderImpl().readFile(INPUT_FILE);
        InputRowParser inputRowParser = new InputRowParserImpl();
        List<FruitRecord> records = inputRowParser.parse(fileData);
        Worker newShop = new WorkerImpl(amountStrategy);
        newShop.processData(records);
        ReportWriter newReportWriter = new ReportWriterImpl();
        newReportWriter.writeReportToFile(REPORT_FILE);
    }
}
