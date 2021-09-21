import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import operationtype.BalanceOperation;
import operationtype.OperationHandler;
import operationtype.PurchaseOperation;
import operationtype.ReturnOperation;
import operationtype.SupplyOperation;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ParseData;
import service.ParseDataImpl;
import service.StorageService;
import service.StorageServiceImpl;
import service.read.ReadService;
import service.read.ReadServiceImpl;
import service.write.WriteService;
import service.write.WriteServiceImpl;

public class Main {
    public static void main(String[] args) {
        String pathToRead = "src/main/resources/inputFile.csv";

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperation());
        operationHandlerMap.put("p", new PurchaseOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        operationHandlerMap.put("s", new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        ParseData parseData = new ParseDataImpl();
        StorageService storageService = new StorageServiceImpl(operationStrategy);
        WriteService writeService = new WriteServiceImpl();
        List<String[]> extractedInformation = readService.read(pathToRead);
        List<FruitRecord> fruitRecords = parseData.recordingData(extractedInformation);
        Map<String, Integer> stringIntegerMap = storageService.processingData(fruitRecords);
        String result = writeService.prepareToWrite(stringIntegerMap);
        String pathToWrite = "src/main/resources/report.csv";
        writeService.write(result, pathToWrite);
    }
}
