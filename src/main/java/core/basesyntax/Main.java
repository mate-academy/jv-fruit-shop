package core.basesyntax;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.FileReader;
import service.FileWriter;
import service.FruitTransactionMapper;
import service.FruitTransactionService;
import service.ReportCreator;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitTransactionMapperImpl;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReportCreatorImpl;
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

        FruitTransactionMapper converter = new FruitTransactionMapperImpl();
        FruitTransaction[] fruitTransactions = converter.toFruitTransactions(fileData);

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(dao, operationStrategy);
        fruitTransactionService.processData(fruitTransactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();

        FileWriter writer = new FileWriterImpl();
        writer.write(report, REPORT_FILE_NAME);
    }

    public static void initializeMap(Map<FruitTransaction.Operation, OperationHandler> map) {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    }
}
