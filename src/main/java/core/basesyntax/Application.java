package core.basesyntax;

import core.basesyntax.dao.OperationsDao;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ShopItemService;
import core.basesyntax.service.implementations.CsvFileReader;
import core.basesyntax.service.implementations.CsvFileWriter;
import core.basesyntax.service.implementations.CsvToTransactionDtoParser;
import core.basesyntax.service.implementations.ShopItemServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.implementations.BalanceStrategy;
import core.basesyntax.strategy.implementations.PurchaseStrategy;
import core.basesyntax.strategy.implementations.ReturnStrategy;
import core.basesyntax.strategy.implementations.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        OperationsDao dao = new OperationsDao();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy(dao));
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy(dao));
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy(dao));
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy(dao));
        FileReader fileReaderService = new CsvFileReader();
        List<String> linesFromFile =
                fileReaderService.getAllLines("src/main/resources/FileReaderTest.csv");
        CsvParser<TransactionDto> parser = new CsvToTransactionDtoParser();
        List<TransactionDto> parsed = parser.parse(linesFromFile);
        ShopItemService shopService = new ShopItemServiceImpl(operationStrategyMap);
        shopService.applyOperationOnShopItem(parsed);
        String report = shopService.getStringReport();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report,"src/main/resources/result.csv");
    }
}
