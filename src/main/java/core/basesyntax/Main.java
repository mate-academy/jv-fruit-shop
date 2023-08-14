package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME =
            "src/main/java/core/basesyntax/files/input_db.csv";
    private static final String OUTPUT_FILE_NAME =
            "src/main/java/core/basesyntax/files/output_db.csv";
    private final ReaderService readerService = new ReaderServiceImpl();
    private final WriteService writeService = new WriteServiceImpl();
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private final FruitDao fruitDao = new FruitDaoImpl();

    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(fruitDao, fruitTransactionDao);
    private final ProcessDataService processDataService =
            new ProcessDataServiceImpl(operationStrategy);
    private final ReportService reportService = new ReportServiceImpl(fruitDao);

    public static void main(String[] args) {
        Main main = new Main();
        // read data from file
        List<FruitTransaction> fruitTransactions = main.readDataFromFile();
        // add fruit transactions to DB
        main.addTransactionsToDb(fruitTransactions);
        // print fruit transactions
        main.print(fruitTransactions);
        // process fruit transactions
        main.processData(fruitTransactions);
        // get processed data (fruits) from DB
        List<Fruit> fruits = main.getFruitsFromDb();
        // print fruits
        main.print(fruits);
        // create report
        String report = main.createReport(fruits);
        // print report
        System.out.println("Report:\n" + report);
        // write report to file
        main.writeDataToFile(report);
    }

    public <T> void print(List<T> list) { // TODO: correct if necessary
        list.forEach(System.out::println);
    }

    public List<FruitTransaction> readDataFromFile() {
        return readerService.readDataFromFile(INPUT_FILE_NAME);
    }

    public void addTransactionsToDb(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            fruitTransactionDao.add(fruitTransaction);
        }
    }

    public void processData(List<FruitTransaction> fruitTransactions) {
        processDataService.processData(fruitTransactions);
    }

    private String createReport(List<Fruit> fruits) {
        return reportService.createReport(fruits);
    }

    private void writeDataToFile(String data) {
        writeService.writeDataToFile(OUTPUT_FILE_NAME, data);
    }

    public List<Fruit> getFruitsFromDb() {
        return fruitDao.getAll();
    }
}
