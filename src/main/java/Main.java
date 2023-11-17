import db.FruitShopDao;
import db.FruitShopDaoCsvImpl;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.ProcessCsvDataService;
import service.ReportGenerationService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.ProcessCsvDataServiceImpl;
import service.impl.ReportGenerationServiceImpl;
import strategy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlerMap);

        FruitShopDao fruitShopDao = new FruitShopDaoCsvImpl(fruitStrategy);
        CsvFileReaderService service = new CsvFileReaderServiceImpl();
        List<String> list = service.readFromCsvFile("input_file.csv");

        ProcessCsvDataService service1 = new ProcessCsvDataServiceImpl(fruitShopDao);
        service1.processData(list);

        ReportGenerationService service2 = new ReportGenerationServiceImpl(fruitShopDao);
        List<String> report = service2.generateReport();

        CsvFileWriterService service3 = new CsvFileWriterServiceImpl();
        service3.writeToNewCsvFile("some_outputfile2.csv", report);
    }
}
