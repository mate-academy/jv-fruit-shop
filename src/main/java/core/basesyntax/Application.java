package core.basesyntax;

import core.basesyntax.servise.FruitRecordDto;
import core.basesyntax.servise.Operation;
import core.basesyntax.servise.ReportBuilderImpl;
import core.basesyntax.servise.ReportReaderImpl;
import core.basesyntax.servise.ReportWriterImpl;
import core.basesyntax.servise.inrterfase.ReportBuilder;
import core.basesyntax.servise.inrterfase.ReportReader;
import core.basesyntax.servise.inrterfase.ReportWriter;
import core.basesyntax.storage.Strategy;
import core.basesyntax.storage.StrategyAdd;
import core.basesyntax.storage.StrategySubtraction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String DIRECT_INPUT_FILE = "src/resources/input report.csv";
    private static final String DIRECT_OUTPUT_FILE = "src/resources/output report.csv";

    public static void main(String[] args) {
        Map<Operation, Strategy> strategyOperation = new HashMap<>();
        strategyOperation.put(Operation.BALANCE, new StrategyAdd());
        strategyOperation.put(Operation.SUPPLY, new StrategyAdd());
        strategyOperation.put(Operation.PURCHASE, new StrategySubtraction());
        strategyOperation.put(Operation.RETURN, new StrategyAdd());

        ReportReader reportReader = new ReportReaderImpl();
        List<String> report = reportReader.readFile(DIRECT_INPUT_FILE);
        ReportBuilder splitter = new ReportBuilderImpl();
        List<FruitRecordDto> fruitRecordDtos = splitter.getReport(report);
        for (FruitRecordDto fruitRecordDto : fruitRecordDtos) {
            Strategy local = strategyOperation.get(fruitRecordDto.getType());
            if (local != null) {
                local.changeBalance(fruitRecordDto);
            }
        }
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(DIRECT_OUTPUT_FILE);
    }
}
