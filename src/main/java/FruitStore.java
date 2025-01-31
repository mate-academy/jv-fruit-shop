import dao.TransactionDaoImpl;
import service.CSVProcessor;

public class FruitStore {
    public static void main(String[] args) {
        TransactionDaoImpl inventoryDAO = new TransactionDaoImpl();
        CSVProcessor csvProcessor = new CSVProcessor(inventoryDAO);
        csvProcessor.processCSV("src/main/java/testFruitsReport");
        inventoryDAO.exportToCSV("src/main/java/output");
    }
}
