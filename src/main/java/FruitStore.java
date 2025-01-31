import dao.TransactionDaoImpl;
import dao.TransactionsDao;
import service.CsvProcessService;
import service.CsvReportGeneratorService;

public class FruitStore {
    private static final String INPUT_PATH = "testFruitsReport";
    private static final String OUTPUT_PATH = "output";

    public static void main(String[] args) {
        TransactionsDao inventoryDao = new TransactionDaoImpl();
        CsvProcessService csvProcessService = new CsvProcessService(inventoryDao);
        CsvReportGeneratorService reportGenerator = new CsvReportGeneratorService(inventoryDao);

        csvProcessService.processCsv(INPUT_PATH);
        reportGenerator.exportToCsv(OUTPUT_PATH);
    }
}
