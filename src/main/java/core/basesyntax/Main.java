package core.basesyntax;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.FileConverter;
import service.FileReader;
import service.ProcessDataService;
import service.ReportCreator;
import service.ReportWriter;
import service.impl.FileConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.ProcessDataServiceImpl;
import service.impl.ReportCreatorImpl;
import service.impl.ReportWriterImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FRUIT_SHOP_FILE_NAME = "src\\main\\resources\\During the day.csv";
    private static final String REPORT_FILE_NAME = "src\\main\\resources\\Report file.csv";

    public static void main(String[] args) {
        FruitDao dao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        initializeMap(operationHandlerMap);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FileReader reader = new FileReaderImpl();
        String fileData = reader.readFile(FRUIT_SHOP_FILE_NAME);

        FileConverter converter = new FileConverterImpl();
        FruitTransaction[] fruitTransactions = converter.convertToFruitTransactions(fileData);

        ProcessDataService processDataService = new ProcessDataServiceImpl(dao, operationStrategy);
        processDataService.processData(fruitTransactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();

        ReportWriter writer = new ReportWriterImpl();
        writer.write(report, REPORT_FILE_NAME);
    }

    public static void initializeMap(Map<FruitTransaction.Operation, OperationHandler> map) {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    }
}
