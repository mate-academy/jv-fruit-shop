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
    private static final String Read_File_Path = "src/main/resources/FruitShop_db";
    private static final String File_Write_Path = "src/main/resources/FruitStore_Report";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(createOperationHandlerMap(fruitDao));
        ReaderService readerService = new ReaderServiceImpl();

        List<String> data = readerService.readFromFile(Read_File_Path);
        Parser parser = new CsvParserImpl();

        List<Transaction> transactions = parser.parse(data);
        transactionService.excuteTransactions(transactions);
        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.generateReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(File_Write_Path, report);
    }

    private static Map<Operation, OperationHandler> createOperationHandlerMap(
            FruitDao fruitDao) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        map.put(Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        map.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        map.put(Operation.RETURN, new ReturnOperationHandler(fruitDao));
        return map;
    }
}
