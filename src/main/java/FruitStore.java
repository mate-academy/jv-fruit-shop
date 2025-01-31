import dao.TransactionDaoImpl;
import service.CsvProcessor;

public class FruitStore {
    public static void main(String[] args) {
        TransactionDaoImpl inventoryDao = new TransactionDaoImpl();
        CsvProcessor csvProcessor = new CsvProcessor(inventoryDao);
        csvProcessor.processCsv("src/main/resources/testFruitsReport");
        inventoryDao.exportToCsv("src/main/resources/output");
    }
}
