package services;

import dao.ProductDao;
import java.util.List;
import services.transaction.TransactionService;
import services.transaction.TransactionServiceImpl;
import services.transaction.ProductTransactionMapper;
import services.transaction.model.ProductTransaction;

public class FruitServiceImpl implements FruitService {
    private final FileReaderService reader;
    private final WriterService writerService;
    private final ProductTransactionMapper unboxer;
    private final OperationStrategy strategy;
    private final ProductDao productDao;
    private List<String> allTransactionsStr;
    private List<ProductTransaction> productTransactions;
    private TransactionService transactionService;
    private ReportService reportService;

    public FruitServiceImpl(FileReaderService reader, WriterService writerService, ProductTransactionMapper unboxer, OperationStrategy strategy, ProductDao productDao, ReportService reportService) {
        this.reader = reader;
        this.writerService = writerService;
        this.unboxer = unboxer;
        this.strategy = strategy;
        this.productDao = productDao;
        this.reportService = reportService;
    }

    @Override
    public void run(String fromFile, String toFile) {
        allTransactionsStr = reader.readFromFile(fromFile);
        productTransactions = unboxer.getProductTransactions(allTransactionsStr);
        transactionService = new TransactionServiceImpl(strategy);
        transactionService.process(productTransactions);
        writerService.writeToFile(toFile, reportService.report(productDao.getAll()));
    }
}
