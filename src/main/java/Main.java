import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.OperationTypes;
import model.TransactionDto;
import services.Reporting;
import services.ReportingImpl;
import services.operations.Operation;
import services.operations.OperationBalanceImpl;
import services.operations.OperationPurchaseImpl;
import services.operations.OperationReturnImpl;
import services.operations.OperationSupplyImpl;
import services.operations.strategy.OperationsStrategy;
import services.operations.strategy.OperationsStrategyImpl;
import services.readfromfile.ReadingFromFile;
import services.readfromfile.ReadingFromFileImpl;
import services.writetofile.WriteToFile;
import services.writetofile.WriteToFileImpl;

public class Main {
    public static void main(String[] args) {
        Map<String, Operation> stringOperationMap = new HashMap<>();
        stringOperationMap.put(OperationTypes.BALANCE.getShortName(), new OperationBalanceImpl());
        stringOperationMap.put(OperationTypes.SUPPLY.getShortName(), new OperationSupplyImpl());
        stringOperationMap.put(OperationTypes.PURCHASE.getShortName(), new OperationPurchaseImpl());
        stringOperationMap.put(OperationTypes.RETURN.getShortName(), new OperationReturnImpl());
        OperationsStrategy strategyOperations = new OperationsStrategyImpl(stringOperationMap);
        String filePath = "src/main/resources/file.csv";
        ReadingFromFile readingFromFile = new ReadingFromFileImpl();
        List<TransactionDto> transactionDtos = readingFromFile.readingFromFile(filePath);
        Reporting reporting = new ReportingImpl(strategyOperations);
        List<String> report = reporting.createReport(transactionDtos);
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeToFile(report);
        report.forEach(System.out::println);
    }
}
