package core.basesyntax;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.impl.FruitOperationDaoImpl;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileWriter;
import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.ParseRowToObjectService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FruitReportServiceImpl;
import core.basesyntax.service.impl.ParseRowToObjectServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, BigDecimal> inventory = new HashMap<>();
        FileWriter writer = new FileWriter();
        FileReader reader = new FileReader();
        FruitOperationDao fruitOperationDao = new FruitOperationDaoImpl(reader, writer);
        TransactionService transactionService = new TransactionServiceImpl(inventory);
        FruitReportService reportService = new FruitReportServiceImpl(inventory);
        ParseRowToObjectService parseRowToObjectService
                = new ParseRowToObjectServiceImpl(fruitOperationDao);
        List<FruitTransaction> parseRowToObjects = parseRowToObjectService.parseRowToObjects();
        boolean success = transactionService.processTransactions(parseRowToObjects);
        if (success) {
            List<FruitReport> reports = reportService.generateInventoryReport();
            fruitOperationDao.writeToFile(reports);
        } else {
            System.err.println("Transaction processing failed.");
        }
    }
}
