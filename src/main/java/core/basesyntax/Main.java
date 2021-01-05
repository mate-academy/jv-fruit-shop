package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operations = new HashMap<>();
        operations.put(Operation.BALANCE, new BalanceStrategy());
        operations.put(Operation.PURCHASE, new PurchaseStrategy());
        operations.put(Operation.RETURN, new ReturnStrategy());
        operations.put(Operation.SUPPLY, new SupplyStrategy());

        CsvFileReader csvFileReader = new CsvFileReader();
        FruitServiceImpl fruitService = new FruitServiceImpl(operations);
        CsvFileWriter fileWriter = new CsvFileWriter();
        TransactionParser parser = new TransactionParserImpl();

        List<TransactionDto> transactionDtoList = parser
                .parse(csvFileReader.readData("src/main/java/resources/fruits.csv"));
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Map<String, Integer> fruitReport = fruitService.getFruitReport();
        fileWriter.createReportFile(fruitReport, "src/main/java/resources/fruits-report.csv");
    }
}
