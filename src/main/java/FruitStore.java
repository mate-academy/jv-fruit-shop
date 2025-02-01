import dao.TransactionDaoImpl;
import dao.TransactionsDao;
import service.CsvParseService;
import service.CsvReadService;
import service.CsvTransactionService;
import service.CsvWriteService;

public class FruitStore {
    public static void main(String[] args) {
        TransactionsDao transactionDao = new TransactionDaoImpl();
        CsvWriteService reportGenerator = new CsvWriteService(transactionDao);
        CsvParseService csvParseService = new CsvParseService();
        CsvReadService csvReadService = new CsvReadService(csvParseService);
        CsvTransactionService csvTransactionService = new CsvTransactionService(transactionDao, csvReadService);

        csvTransactionService.processCsv();
        reportGenerator.exportToCsv();
    }
}
