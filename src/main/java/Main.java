import dao.ProductDao;
import dao.ProductDaoImpl;
import java.util.HashMap;
import java.util.Map;
import services.FileReaderService;
import services.FileReaderServiceImpl;
import services.FileWriterService;
import services.FileWriterServiceImpl;
import services.FruitService;
import services.FruitServiceImpl;
import services.OperationStrategy;
import services.OperationStrategyImpl;
import services.ReportService;
import services.ReportServiceImpl;
import services.operation.BalanceOperation;
import services.operation.OperationHandler;
import services.operation.PurchaseOperation;
import services.operation.ReturnOperation;
import services.operation.SupplyOperation;
import services.transaction.ProductTransactionMapper;
import services.transaction.ProductTransactionMapperImpl;
import services.transaction.TransactionService;
import services.transaction.TransactionServiceImpl;
import services.transaction.model.ProductTransaction;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();

        Map<ProductTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(ProductTransaction.Operation.BALANCE, new BalanceOperation(productDao));
        operationMap.put(ProductTransaction.Operation.PURCHASE, new PurchaseOperation(productDao));
        operationMap.put(ProductTransaction.Operation.SUPPLY, new SupplyOperation(productDao));
        operationMap.put(ProductTransaction.Operation.RETURN, new ReturnOperation(productDao));

        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        FileReaderService reader = new FileReaderServiceImpl();
        ProductTransactionMapper mapper = new ProductTransactionMapperImpl();
        FileWriterService writer = new FileWriterServiceImpl();
        ReportService report = new ReportServiceImpl();
        TransactionService trService = new TransactionServiceImpl(strategy);

        FruitService fruitService =
                new FruitServiceImpl(reader, writer, mapper, productDao, report, trService);

        String fromFile = "src/main/java/data.csv";
        String toFile = "report.csv";
        fruitService.run(fromFile, toFile);
    }
}
