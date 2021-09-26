package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.DecreaseOperationHandler;
import core.basesyntax.service.strategy.impl.IncreaseOperationHandler;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void run() {
        Map<FruitRecord.Operation, OperationHandler> operationsMap = Map.of(
                FruitRecord.Operation.BALANCE, new IncreaseOperationHandler(),
                FruitRecord.Operation.SUPPLY, new IncreaseOperationHandler(),
                FruitRecord.Operation.PURCHASE, new DecreaseOperationHandler(),
                FruitRecord.Operation.RETURN, new IncreaseOperationHandler()
        );

        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFile(INPUT_FILE);

        DataParserService<FruitRecord, String> dataParserService = new ParserServiceImpl();
        List<FruitRecord> fruitRecords = dataParserService.parseData(data);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        DataHandlerService dataHandlerService = new DataHandlerServiceImpl(operationStrategy);
        Map<String, Integer> tmp = dataHandlerService.handleData(fruitRecords);

        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(OUTPUT_FILE, reportService.createReport(tmp));
    }
}
