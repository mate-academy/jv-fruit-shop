package services;

import dao.ProductDao;
import java.util.List;
import services.transaction.ProductTransactionMapper;
import services.transaction.TransactionService;
import services.transaction.model.ProductTransaction;

public class FruitServiceImpl implements FruitService {
    private final FileReaderService reader;
    private final FileWriterService writerService;
    private final ProductTransactionMapper mapper;
    private final ProductDao productDao;
    private TransactionService transactionService;
    private ReportService reportService;

    public FruitServiceImpl(FileReaderService reader, FileWriterService writerService,
                            ProductTransactionMapper mapper, ProductDao productDao,
                            ReportService reportService, TransactionService transactionService) {
        this.reader = reader;
        this.writerService = writerService;
        this.mapper = mapper;
        this.productDao = productDao;
        this.reportService = reportService;
        this.transactionService = transactionService;
    }

    @Override
    public void run(String fromFile, String toFile) {
        List<String> allTransactionsStr = reader.readFromFile(fromFile);
        List<ProductTransaction> prTransactions = mapper.getProductTransactions(allTransactionsStr);
        transactionService.process(prTransactions);
        writerService.writeToFile(toFile, reportService.createReport(productDao.getAll()));
    }
}
