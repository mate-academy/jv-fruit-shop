import dao.FruitTransactionDao;
import dao.FruitTransactionDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.BalanceOperationHandler;
import operation.OperationHandler;
import operation.OperationStrategy;
import operation.OperationStrategyImpl;
import operation.PurchaseOperationHandler;
import operation.ReturnOperationHandler;
import operation.SupplyOperationHandler;
import read.file.ReaderFromFile;
import read.file.ReaderFromFileImpl;
import service.FruitTransactionService;
import service.FruitTransactionServiceImpl;
import service.TransactionService;
import service.TransactionServiceImpl;
import write.file.WriteToFile;
import write.file.WriteToFileImpl;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src\\main\\resources\\inputData.csv";
        final String reportFile = "src\\main\\resources\\reportData.csv";
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationHandler());
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(fruitTransactionDao);
        ReaderFromFile readerFromFile = new ReaderFromFileImpl();
        List<String[]> fruitsInputDataList = readerFromFile.readFromFile(inputFile);
        fruitTransactionService.createNewFruitTransaction(fruitsInputDataList);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionService transactionService =
                new TransactionServiceImpl(operationStrategy,fruitTransactionDao);
        Map<String, Integer> updatedFruitsStock = transactionService.countsFruitsAfterWorkDay();
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.write(updatedFruitsStock,reportFile);
    }
}
