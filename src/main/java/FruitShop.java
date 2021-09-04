import dto.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.FruitParser;
import service.ReportFruitImpl;
import service.ValidatorImpl;
import strategy.BalanceOperation;
import strategy.Operation;
import strategy.PurchaseOperation;
import strategy.SupplyOperation;

public class FruitShop {
    public static void main(String[] args) {
        Map<String, Operation> operationsMap = new HashMap<>();
        operationsMap.put("b", new BalanceOperation());
        operationsMap.put("s", new SupplyOperation());
        operationsMap.put("p", new PurchaseOperation());
        operationsMap.put("r", new SupplyOperation());
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> listData = fileReader.readFromFile("src/main/resources/input.csv");
        listData.remove(0);
        ValidatorImpl validator = new ValidatorImpl();

        FruitParser parser = new FruitParser();
        for (String line : listData) {
            validator.checkInputData(line.split(","));
            Transaction transaction = parser.parseData(line);
            operationsMap.get(transaction.getOperation()).apply(transaction);
        }
        ReportFruitImpl fruitReport = new ReportFruitImpl();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile("src/main/resources/output.csv", fruitReport.getReport());
    }
}
