import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import operationtype.BalanceHandler;
import operationtype.OperationHandler;
import operationtype.PurchaseHandler;
import operationtype.ReturnHandler;
import operationtype.SupplyHandler;
import service.FruitCounter;
import service.FruitCounterImpl;
import service.FruitRecordParser;
import service.FruitRecordParserImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.read.FileReader;
import service.read.FileReaderImpl;
import service.write.FileWriter;
import service.write.FileWriterImpl;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/inputFile.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("r", new ReturnHandler());
        operationHandlerMap.put("s", new SupplyHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReader fileReader = new FileReaderImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        FruitCounter fruitCounter = new FruitCounterImpl(operationStrategy);
        FileWriter fileWriter = new FileWriterImpl();
        List<String[]> extractedInformation = fileReader.read(PATH_TO_READ);
        List<FruitRecord> fruitRecords = fruitRecordParser.parse(extractedInformation);
        fruitCounter.countFruit(fruitRecords);
        String report = fileWriter.prepareToWrite();

        fileWriter.write(report, PATH_TO_WRITE);
    }
}
