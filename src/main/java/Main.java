import fileservice.CsvFileReadServiceImpl;
import fileservice.WriteDataInFileServiceImpl;
import fruittransaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import parser.TransactionParserImpl;
import reportservice.ReportServiceImpl;
import strategy.OperationStrategyImpl;
import transactionexecutor.OperationHandler;
import transactionexecutor.OperationHandlerBalanceImpl;
import transactionexecutor.OperationHandlerPurchaseImpl;
import transactionexecutor.OperationHandlerReturnImpl;
import transactionexecutor.OperationHandlerSupplyImpl;
import transactionexecutor.TransactionExecutorImpl;

public class Main {
    public static void main(String[] args) {
        OperationHandler operationHandlerBalanceImpl = new OperationHandlerBalanceImpl();
        OperationHandlerPurchaseImpl operationHandlerPurchase = new OperationHandlerPurchaseImpl();
        OperationHandlerReturnImpl operationHandlerReturn = new OperationHandlerReturnImpl();
        OperationHandlerSupplyImpl operationHandlerSupply = new OperationHandlerSupplyImpl();

        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, operationHandlerBalanceImpl);
        map.put(FruitTransaction.Operation.PURCHASE, operationHandlerPurchase);
        map.put(FruitTransaction.Operation.RETURN, operationHandlerReturn);
        map.put(FruitTransaction.Operation.SUPPLY, operationHandlerSupply);

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(map);
        CsvFileReadServiceImpl csvFileReadService = new CsvFileReadServiceImpl();
        TransactionParserImpl transactionParser = new TransactionParserImpl();
        TransactionExecutorImpl transactionExecutor
                = new TransactionExecutorImpl(operationStrategy);
        ReportServiceImpl reportService = new ReportServiceImpl();
        WriteDataInFileServiceImpl writeDataInFileService = new WriteDataInFileServiceImpl();

        List<String> listForParsing = csvFileReadService.read("src/main/java/resource/test.csv");
        List<FruitTransaction> completeFruitsObjectList = transactionParser.parse(listForParsing);
        transactionExecutor.execute(completeFruitsObjectList);
        String completeContentForNewFile = reportService.createReport();
        writeDataInFileService.write("src/main/java/resource/Result.csv",
                completeContentForNewFile);
    }
}

