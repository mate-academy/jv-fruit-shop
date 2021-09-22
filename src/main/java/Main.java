import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import operationtype.BalanceHandler;
import operationtype.OperationHandler;
import operationtype.PurchaseHandler;
import operationtype.ReturnHandler;
import operationtype.SupplyHandler;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.FruitRecordParser;
import service.FruitRecordParserImpl;
import service.FruitCounter;
import service.FruitCounterImpl;
import service.read.ReadService;
import service.read.ReadServiceImpl;
import service.write.WriteService;
import service.write.WriteServiceImpl;

public class Main {
    public static void main(String[] args) {
        String pathToRead = "src/main/resources/inputFile.csv";

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("r", new ReturnHandler());
        operationHandlerMap.put("s", new SupplyHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        FruitCounter fruitCounter = new FruitCounterImpl(operationStrategy);
        WriteService writeService = new WriteServiceImpl();
        List<String[]> extractedInformation = readService.read(pathToRead);
        List<FruitRecord> fruitRecords = fruitRecordParser.parse(extractedInformation);
        Map<String, Integer> fruitBalanceMap = fruitCounter.countFruit(fruitRecords);
        String report = writeService.prepareToWrite(fruitBalanceMap);
        String pathToWrite = "src/main/resources/report.csv";
        writeService.write(report, pathToWrite);
    }
}
