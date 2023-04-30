import static db.StorageTotalBalance.fruitStorageTotalBalance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.CalculationService;
import service.FileService;
import service.OperationHandler;
import service.Parser;
import service.ReportCreator;
import service.impl.AddingOperationHandler;
import service.impl.CalculationServiceImpl;
import service.impl.FileServiceImpl;
import service.impl.ParserImpl;
import service.impl.ReportCreatorImpl;
import service.impl.SubtractOperationHandler;

public class Main {
    private static final String FROM_FILE_NAME =
            "src/main/resources/type,fruit,quantity.csv";
    private static final String TO_FILE_NAME =
            "src/main/resources/report - fruit_total_balance.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> calculationHandlerMap = new HashMap<>();
        calculationHandlerMap.put(Operation.RETURN, new AddingOperationHandler());
        calculationHandlerMap.put(Operation.SUPPLY, new AddingOperationHandler());
        calculationHandlerMap.put(Operation.BALANCE, new AddingOperationHandler());
        calculationHandlerMap.put(Operation.PURCHASE, new SubtractOperationHandler());

        FileService fileService = new FileServiceImpl();
        List<String> dataFromFile = fileService.readFromFile(FROM_FILE_NAME);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitList = parser.parse(dataFromFile);

        CalculationService calculationService = new CalculationServiceImpl(calculationHandlerMap);
        calculationService.calculate(fruitList);

        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String> report = reportCreator.create(fruitStorageTotalBalance);
        fileService.writeToFile(report, TO_FILE_NAME);
    }
}

