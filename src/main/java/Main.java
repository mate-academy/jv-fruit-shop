import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import operation.OperationHendler;
import operation.handlerimpl.BalanceHandlerImpl;
import operation.handlerimpl.PurshaseHandlerImpl;
import operation.handlerimpl.ReturnHandlerImpl;
import operation.handlerimpl.SupplyHandlerImpl;
import service.ParserService;
import service.QuantityService;
import service.ReaderService;
import service.ReportService;
import service.WriteService;
import service.impl.ParserServiceImpl;
import service.impl.QuantityServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteServiceImpl;

public class Main {
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();
    private static final String FILE_TRANSACTION_PATH = "src/main/resources/transaction.csv";
    private static final String FILE_REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHendler> operationHendlerMap = new HashMap<>();
        operationHendlerMap.put(Operation.BALANCE, new BalanceHandlerImpl(FRUIT_STORAGE_DAO));
        operationHendlerMap.put(Operation.RETURN, new ReturnHandlerImpl(FRUIT_STORAGE_DAO));
        operationHendlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl(FRUIT_STORAGE_DAO));
        operationHendlerMap.put(Operation.PURCHASE, new PurshaseHandlerImpl(FRUIT_STORAGE_DAO));

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFile(FILE_TRANSACTION_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseFruitTransaction(lines);

        QuantityService quantityService = new QuantityServiceImpl(operationHendlerMap);
        quantityService.calculateQuantityForFruits(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(FRUIT_STORAGE_DAO);
        String report = reportService.generateReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.writeReport(FILE_REPORT_PATH, report);

    }
}
