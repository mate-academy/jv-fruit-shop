package core.basesyntax.shop;

import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import core.basesyntax.shop.service.CsvFileReader;
import core.basesyntax.shop.service.CsvFileWriter;
import core.basesyntax.shop.service.FileReader;
import core.basesyntax.shop.service.FileWriter;
import core.basesyntax.shop.service.ShopService;
import core.basesyntax.shop.service.ShopServiceImpl;
import core.basesyntax.shop.strategy.AdditionStrategy;
import core.basesyntax.shop.strategy.OperationStrategy;
import core.basesyntax.shop.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationStarter {
    public static final String DAY_ACTIVITY_PATH = "src/main/resources/DayActivity.csv";
    public static final String REPORT_PATH = "src/main/resources/report-fruit.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        FileReader reader = new CsvFileReader();
        List<TransactionDto> transactionDtos = reader.readData(DAY_ACTIVITY_PATH);
        ShopService service = new ShopServiceImpl(operationStrategyMap);
        service.applyOperationOnFruitsDto(transactionDtos);

        FileWriter writer = new CsvFileWriter();
        writer.createReportFile(service.getFruitReport(), REPORT_PATH);
    }
}
