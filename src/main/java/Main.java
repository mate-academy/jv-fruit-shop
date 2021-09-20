import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operationhandler.BalanceOperation;
import operationhandler.OperationHandler;
import operationhandler.PurchaseOperation;
import operationhandler.ReturnOperation;
import operationhandler.SupplyOperation;
import read.ReaderService;
import read.ReaderServiceImpl;
import write.WriteService;
import write.WriteServiceImpl;

public class Main {
    public static void main(String[] args) {
        String pathToRead = "src/main/resources/aaa.csv";

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperation());
        operationHandlerMap.put("p", new PurchaseOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        operationHandlerMap.put("s", new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        FruitRecord fruitRecord = new FruitRecord();
        StorageService storageService = new StorageServiceImpl(operationStrategy);
        WriteService writeService = new WriteServiceImpl();
        List<String[]> extractedInformation = readerService.read(pathToRead);
        List<FruitRecord> fruitRecords = fruitRecord.recordingData(extractedInformation);
        Map<String, Integer> stringIntegerMap = storageService.processingData(fruitRecords);
        String result = writeService.prepareToWrite(stringIntegerMap);
        String pathToWrite = "src/main/resources/file.csv";
        writeService.write(result, pathToWrite);
    }
}
