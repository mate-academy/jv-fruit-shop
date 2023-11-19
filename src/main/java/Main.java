import db.FruitShopDao;
import db.FruitShopDaoCsvImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Operation;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.ProcessCsvDataService;
import service.ReportGenerationService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.ProcessCsvDataServiceImpl;
import service.impl.ReportGenerationServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.FruitStrategy;
import strategy.FruitStrategyImpl;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output_file.csv";

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoCsvImpl();

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler(fruitShopDao));
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler(fruitShopDao));
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler(fruitShopDao));

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlerMap);

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> list = readerService.readFromCsvFile(INPUT_FILE_NAME);

        ProcessCsvDataService processService = new ProcessCsvDataServiceImpl(fruitShopDao, fruitStrategy);
        processService.processData(list);

        ReportGenerationService reportGenerationService =
                new ReportGenerationServiceImpl(fruitShopDao);
        List<String> report = reportGenerationService.generateReport();

        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToNewCsvFile(OUTPUT_FILE_NAME, report);
    }
}
