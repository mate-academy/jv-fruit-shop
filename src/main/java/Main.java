import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParserService;
import service.ReadService;
import service.ReportService;
import service.WriteService;
import service.impl.ParserServiceImpl;
import service.impl.ReadServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.FruitStrategy;
import strategy.FruitStrategyImpl;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        final String InputFile = "src/main/resources/inputData.csv";
        final String outputFile = "src/main/resources/report.csv";

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlerMap);
        ParserService parser = new ParserServiceImpl();
        ReadService reader = new ReadServiceImpl();

        List<String> stringsFromInputData = reader.readFile(InputFile);

        List<FruitTransaction> fruitTransactions = parser.parseTransactions(stringsFromInputData);

        for (FruitTransaction transaction : fruitTransactions) {
            fruitStrategy.get(transaction.getOperation()).operate(transaction);
        }

        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.getReport();

        WriteService writer = new WriteServiceImpl();
        writer.writeFile(report.toString(), outputFile);
    }
}
