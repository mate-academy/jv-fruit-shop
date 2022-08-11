package service;

import dao.ProductDao;
import dao.ProductDaoImpl;

import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService{
    private static final int TYPE_INDEX = 0;
    private static final ReaderService reader = new ReaderServiceImpl();
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ProductDao productDao = new ProductDaoImpl();
    private final OperationStrategy strategy;
    private final String newFileName;
    private final WriterService writerService = new WriterServiceImpl();

    public FruitServiceImpl(OperationStrategy strategy, String FileToWrite) {
        this.strategy = strategy;
        this.newFileName = FileToWrite;
    }

    @Override
    public void report(String fromFile, String toFile) {
        List<String> allTransactionsString = reader.readFromFile(fromFile);
        List<ProductTransaction> productTransactions = allTransactionsString.stream().map(i -> {
            String[] dataTransactions = i.split(",");
            return new ProductTransaction(
                                        ProductTransaction.Operation.valueOf(dataTransactions[PRODUCT_INDEX]),
                                        dataTransactions[PRODUCT_INDEX],
                                        Integer.parseInt(dataTransactions[QUANTITY_INDEX]));
        }).collect(Collectors.toList());

        productTransactions.forEach(transaction -> strategy.get(transaction.getOperation()).doOperation(transaction));

        writerService.writeToFile(newFileName);
    }
}
