package services;

import dao.ProductDao;
import java.util.List;
import services.transaction.ProductTransactionMapper;
import services.transaction.TransactionService;
import services.transaction.model.ProductTransaction;

public class FruitServiceImpl implements FruitService {
    private final FileReaderService reader;
    private final WriterService writerService;
    private final ProductTransactionMapper unboxer;
    private final ProductDao productDao;
    private List<String> allTransactionsStr;
    private List<ProductTransaction> productTransactions;
    private TransactionService transactionService;
    private ReportService reportService;

    public FruitServiceImpl(FileReaderService reader, WriterService writerService,
                            ProductTransactionMapper unboxer, ProductDao productDao,
                            ReportService reportService, TransactionService transactionService) {
        this.reader = reader;
        this.writerService = writerService;
        this.unboxer = unboxer;
        this.productDao = productDao;
        this.reportService = reportService;
        this.transactionService = transactionService;
    }

    @Override
    public void run(String fromFile, String toFile) {
        allTransactionsStr = reader.readFromFile(fromFile);
        productTransactions = unboxer.getProductTransactions(allTransactionsStr);
        transactionService.process(productTransactions);
        writerService.writeToFile(toFile, reportService.report(productDao.getAll()));
    }
}
