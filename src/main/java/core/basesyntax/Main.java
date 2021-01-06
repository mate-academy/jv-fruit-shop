package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());

        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        List<TransactionDto> transactionDto
                = csvFileReader.readFile("src/main/resources/fruit-read.csv");
        FruitService serviceFruit = new FruitServiceImpl(operationStrategyMap);
        serviceFruit.applyOperationsOnFruitsDto(transactionDto);
        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeData("src/main/resources/fruit-write.csv");
    }
}
