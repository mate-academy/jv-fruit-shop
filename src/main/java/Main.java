import java.util.HashMap;
import java.util.List;
import java.util.Map;
import services.Reporting;
import services.ReportingImpl;
import services.operations.Operation;
import services.operations.OperationBalanceImpl;
import services.operations.OperationPurchaseImpl;
import services.operations.OperationReturnImpl;
import services.operations.OperationSupplyImpl;
import services.operations.strategy.StrategyOperations;
import services.operations.strategy.StrategyOperationsImpl;
import services.writetofile.WriteToFile;
import services.writetofile.WriteToFileImpl;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/resources/file.csv";
        Map<String, Operation> stringOperationMap = new HashMap<>();
        stringOperationMap.put("b", new OperationBalanceImpl());
        stringOperationMap.put("s", new OperationSupplyImpl());
        stringOperationMap.put("p", new OperationPurchaseImpl());
        stringOperationMap.put("r", new OperationReturnImpl());
        StrategyOperations strategyOperations = new StrategyOperationsImpl(stringOperationMap);
        Reporting reporting = new ReportingImpl(strategyOperations);
        List<String> report = reporting.createReport(filePath);
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeToFile(report);
        report.forEach(System.out::println);
    }
}
