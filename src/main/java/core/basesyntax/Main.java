package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.fruit.Operation;
import core.basesyntax.fruit.Transaction;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE_PATH = "src/main/resources/FruitShop_db";
    private static final String FILE_WRITE_PATH = "src/main/resources/FruitStore_Report";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final Parser parser = new CsvParserImpl();
    private static final WriteService writeService = new WriteServiceImpl();
    private static final FruitDao fruitDao = new FruitDaoImpl();

    public static void main(String[] args) {
        TransactionService transactionService =
                new TransactionServiceImpl(createOperationHandlerMap(fruitDao));
        List<String> data = readerService.readFromFile(READ_FILE_PATH);
        List<Transaction> transactions = parser.parse(data);
        transactionService.execute(transactions);
        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.generateReport();
        writeService.writeToFile(FILE_WRITE_PATH, report);
    }

    public static Map<Operation, OperationHandler> createOperationHandlerMap(
            FruitDao fruitDao) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        map.put(Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        map.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        map.put(Operation.RETURN, new ReturnOperationHandler(fruitDao));
        return map;
    }
}
