package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.parse.DataParser;
import core.basesyntax.service.parse.DataParserImpl;
import core.basesyntax.service.processor.ShopProcessor;
import core.basesyntax.service.processor.ShopProcessorImpl;
import core.basesyntax.service.read.FileReading;
import core.basesyntax.service.read.FileReadingImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.strategy.TypeStrategy;
import core.basesyntax.service.strategy.TypeStrategyImpl;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.OperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import core.basesyntax.service.write.FileWriter;
import core.basesyntax.service.write.FileWriterImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/test.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReading fileReader = new FileReadingImpl();
        List<String> inputReport = fileReader.read(PATH_TO_READ);

        Map<FruitRecord.Operation, OperationHandler> typeServiceMap = Map.of(
                FruitRecord.Operation.BALANCE, new BalanceOperationHandler(),
                FruitRecord.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitRecord.Operation.RETURN, new ReturnOperationHandler(),
                FruitRecord.Operation.SUPPLY, new SupplyOperationHandler()
        );

        TypeStrategy typeStrategy = new TypeStrategyImpl(typeServiceMap);

        DataParser fruitRecordParser = new DataParserImpl();
        List<FruitRecord> fruitRecords = fruitRecordParser.parseFruitRecords(inputReport);

        ShopProcessor transactionService = new ShopProcessorImpl(typeStrategy);
        transactionService.process(fruitRecords);
        ReportService reportService = new ReportServiceImpl();

        String resultReport = reportService.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(PATH_TO_WRITE, resultReport);
    }
}
