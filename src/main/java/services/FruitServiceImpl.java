package services;

import dao.ProductDao;
import java.util.List;
import services.transaction.TransactionService;
import services.transaction.TransactionServiceImpl;
import services.transaction.UnboxingTransaction;
import services.transaction.UnboxingTransactionImpl;
import services.transaction.model.ProductTransaction;

public class FruitServiceImpl implements FruitService {
    private final FileReaderService reader = new FileReaderServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();
    private final UnboxingTransaction unboxer = new UnboxingTransactionImpl();
    private final OperationStrategy strategy;
    private final ProductDao productDao;

    public FruitServiceImpl(OperationStrategy strategy, ProductDao productDao) {
        this.strategy = strategy;
        this.productDao = productDao;
    }

    @Override
    public void report(String fromFile, String toFile) {
        List<String> allTransactionsStr = reader.readFromFile(fromFile);
        List<ProductTransaction> productTransactions = unboxer.unboxing(allTransactionsStr);
        TransactionService transactionService = new TransactionServiceImpl(strategy);
        transactionService.processing(productTransactions);
        writerService.writeToFile(toFile, productDao.getAll());
    }
}
