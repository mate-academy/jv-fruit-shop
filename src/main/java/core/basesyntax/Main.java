package core.basesyntax;

import core.basesyntax.model.DailyActivity;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.OperationHandlerStrategyImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.strategy.AddOperationHandler;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.SubtractOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        DataReader dataReader = new DataReaderImpl();
        List<String> fileList = dataReader.readFromFile(INPUT_FILE);
        Parser parser = new ParserImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new SubtractOperationHandler());

        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(operationHandlerMap);

        List<DailyActivity> dailyActivities = parser.parse(fileList);
        for (DailyActivity dailyActivity : dailyActivities) {
            OperationHandler operationHandler = operationHandlerStrategy.get(dailyActivity);
            operationHandler.operation(dailyActivity);
        }
        List<String> finalReport = new ReportImpl().createNewReport();

        DataWriter writer = new DataWriterImpl();
        writer.writeDataToFile(finalReport, REPORT_FILE);
    }
}
