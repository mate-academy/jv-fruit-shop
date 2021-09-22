import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitMapService;
import core.basesyntax.service.FruitMapServiceImpl;
import core.basesyntax.service.FruitRecordParser;
import core.basesyntax.service.FruitRecordParserImpl;
import core.basesyntax.service.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.service.operation.ReturnOperationHandlerImpl;
import core.basesyntax.service.operation.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE = "src/main/resources/fruitshop.csv";
    public static final String TO_FILE_PATH = "src/main/resources/dailyfruitshop.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        List<String> fileLines = fileService.readFromFile(FROM_FILE);
        List<FruitRecord> fruitRecordsList = fruitRecordParser.parserFruitRecords(fileLines);
        fruitRecordDao.saveAll(fruitRecordsList);
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put("b", new BalanceOperationHandlerImpl());
        operationHandlersMap.put("s", new SupplyOperationHandlerImpl());
        operationHandlersMap.put("p", new PurchaseOperationHandlerImpl());
        operationHandlersMap.put("r", new ReturnOperationHandlerImpl());
        List<FruitRecord> fruitRecordList = fruitRecordDao.getAll();
        for (FruitRecord fruitRecord : fruitRecordList) {
            OperationHandler operationHandler
                    = operationHandlersMap.get(fruitRecord.getOperationType());
            operationHandler.applyOperation(fruitRecord);
        }
        FruitMapService fruitMapService = new FruitMapServiceImpl();
        String toFileString = fruitMapService.mapFruitMapToString(fruitRecordDao.getFruitMap());
        fileService.writeToFile(TO_FILE_PATH, toFileString);
    }
}
