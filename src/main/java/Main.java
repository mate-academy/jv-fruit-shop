import dao.FruitDao;
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
    private static final String INPUT_FILE = "src/main/resources/file.csv";
    private static final String OUTPUT_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl(new Storage());
        Map<OperationType, FruitOperationService> strategyOperation = new HashMap<>();
        strategyOperation.put(OperationType.BALANCE,
                new FruitBalanceServiceImpl(fruitDao));
        strategyOperation.put(OperationType.SUPPLY,
                new FruitSupplyServiceImpl(fruitDao));
        strategyOperation.put(OperationType.PURCHASE,
                new FruitPurchaseServiceImpl(fruitDao));
        strategyOperation.put(OperationType.RETURN,
                new FruitReturnServiceImpl(fruitDao));
        FileReaderService fileReaderService = new FilReaderImpl();
        List<String> fileContent = fileReaderService.readFromFile(INPUT_FILE);
        List<FruitRecordParserImpl> fruitRecordParsers = new FruitRecordParserImpl()
                .parseLines(fileContent);
        for (FruitRecordParserImpl fruitRecordParser : fruitRecordParsers) {
            FruitOperationService fruitOperationService = strategyOperation
                     .get(fruitRecordParser.getType());
            fruitOperationService.apply(fruitRecordParser);
        }
        String finalReport = new ReportCreateServiceImpl(fruitDao).createReport();
        FileWriterServiceImpl fileWriterService = new FileWriterServiceImpl();
        fileWriterService.fileWriteTo(finalReport, OUTPUT_FILE);
    }
}
