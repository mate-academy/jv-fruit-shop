import dao.FruitDaoImpl;
import database.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.OperationType;
import service.FilReaderImpl;
import service.FileWriterServiceImpl;
import service.FruitBalanceServiceImpl;
import service.FruitPurchaseServiceImpl;
import service.FruitRecordParserImpl;
import service.FruitReturnServiceImpl;
import service.FruitSupplyServiceImpl;
import service.ReportCreateServiceImpl;
import service.interfaces.FileReaderService;
import service.interfaces.FruitOperationService;

public class Main {
    private static final String elementaryFile = "src/main/resources/file.csv";
    private static final String destinationFile = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FilReaderImpl();
        List<String> fileContent = fileReaderService.readFromFile(elementaryFile);
        List<FruitRecordParserImpl> fruitRecordParsers = new FruitRecordParserImpl()
                .parseLines(fileContent);
        Map<OperationType, FruitOperationService> strategyOperation = operationStrategy();
        for (FruitRecordParserImpl fruitRecordParser : fruitRecordParsers) {
            FruitOperationService fruitOperationService = strategyOperation
                     .get(fruitRecordParser.getType());
            fruitOperationService.apply(fruitRecordParser);
        }
        String finalReport = new ReportCreateServiceImpl(new FruitDaoImpl(
                new Storage())).createReport();
        FileWriterServiceImpl fileWriterService = new FileWriterServiceImpl();
        fileWriterService.fileWriteTo(finalReport, destinationFile);
    }

    public static Map<OperationType, FruitOperationService> operationStrategy() {
        Map<OperationType, FruitOperationService> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE,
                new FruitBalanceServiceImpl(new FruitDaoImpl(new Storage())));
        operationStrategy.put(OperationType.SUPPLY,
                new FruitSupplyServiceImpl(new FruitDaoImpl(new Storage())));
        operationStrategy.put(OperationType.PURCHASE,
                new FruitPurchaseServiceImpl(new FruitDaoImpl(new Storage())));
        operationStrategy.put(OperationType.RETURN,
                new FruitReturnServiceImpl(new FruitDaoImpl(new Storage())));
        return operationStrategy;
    }
}
