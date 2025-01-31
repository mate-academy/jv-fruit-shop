import dao.TransactionDaoImpl;
import service.CsvProcessor;

public class FruitStore {
    public static void main(String[] args) {
        TransactionDaoImpl inventoryDAO = new TransactionDaoImpl();
        CsvProcessor csvProcessor = new CsvProcessor(inventoryDAO);
        csvProcessor.processCsv("src/main/java/testFruitsReport");
        inventoryDAO.exportToCsv("src/main/java/output");
    }
}
