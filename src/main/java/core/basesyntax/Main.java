package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.operation.BalanceSetOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/CsvInputData.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/CsvReport.csv";
    private static final Map<FruitTransaction.OperationType,
            OperationHandler> OPERATION_HANDLER_MAP =
            Map.of(FruitTransaction.OperationType.BALANCE, new BalanceSetOperationHandler(),
                    FruitTransaction.OperationType.SUPPLY, new SupplyOperationHandler(),
                    FruitTransaction.OperationType.RETURN, new ReturnOperationHandler(),
                    FruitTransaction.OperationType.PURCHASE, new PurchaseOperationHandler());

    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderService();
        Parser parserService = new ParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new CsvWriterService();
        List<String> fileData = readerService.read(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = parserService.parseDataFromFile(fileData);
        Map<String, Integer> dataFromDatabase = fruitShopService.processData(transactions);
        String report = reportService.createReport(dataFromDatabase);
        writerService.write(report, OUTPUT_FILE_PATH);
    }
}
