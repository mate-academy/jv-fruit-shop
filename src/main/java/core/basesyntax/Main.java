package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.parse.DataParser;
import core.basesyntax.service.parse.DataParserImpl;
import core.basesyntax.service.read.FileReader;
import core.basesyntax.service.read.FileReaderImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.strategy.TypeStrategy;
import core.basesyntax.service.strategy.TypeStrategyImpl;
import core.basesyntax.service.strategy.strategyimpl.BalanceOperationHandler;
import core.basesyntax.service.strategy.strategyimpl.OperationHandler;
import core.basesyntax.service.strategy.strategyimpl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.strategyimpl.ReturnOperationHandler;
import core.basesyntax.service.strategy.strategyimpl.SupplyOperationHandler;
import core.basesyntax.service.write.FileWriter;
import core.basesyntax.service.write.FileWriterImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/test.csv";
    private static final Path PATH_TO_WRITE = Paths.get("src/main/resources/report.csv");

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(PATH_TO_READ);

        Map<FruitRecord.Operation, OperationHandler> typeServiceMap = new HashMap<>();
        typeServiceMap.put(FruitRecord.Operation.BALANCE, new BalanceOperationHandler());
        typeServiceMap.put(FruitRecord.Operation.PURCHASE, new PurchaseOperationHandler());
        typeServiceMap.put(FruitRecord.Operation.RETURN, new ReturnOperationHandler());
        typeServiceMap.put(FruitRecord.Operation.SUPPLY, new SupplyOperationHandler());

        TypeStrategy typeStrategy = new TypeStrategyImpl(typeServiceMap);

        DataParser fruitRecordParser = new DataParserImpl();
        List<FruitRecord> fruitRecords = fruitRecordParser.parseFruitRecords(inputReport);
        ReportService reportService = new ReportServiceImpl();
        String resultReport = reportService.getReport(fruitRecords);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(PATH_TO_WRITE, resultReport);
    }
}
