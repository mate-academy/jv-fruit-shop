package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FileReaderFromCSVImpl;
import core.basesyntax.service.impl.FileWriterToCSVImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationAddition;
import core.basesyntax.strategy.OperationReduction;
import core.basesyntax.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> mapOperation = new HashMap<>();
        mapOperation.put(Operation.BALANCE, new OperationAddition());
        mapOperation.put(Operation.SUPPLY, new OperationAddition());
        mapOperation.put(Operation.PURCHASE, new OperationReduction());
        mapOperation.put(Operation.RETURN, new OperationAddition());

        FileReader csvFileReader = new FileReaderFromCSVImpl("src/main/java/resources/testFile.csv");
        //System.out.println(testReading.readFromFile().toString());
        FruitService fruitService = new FruitServiceImpl(mapOperation);
        FileWriter csvFileWriter = new FileWriterToCSVImpl();

        List<TransactionDto> transactionDtoList = csvFileReader.readFromFile();
        fruitService.applyOperations(transactionDtoList);
        Map<String, Long> fruitReport = fruitService.getReport();
        csvFileWriter.createReportFile(fruitReport, "src/main/java/resources/report-testFile.csv");
    }
}
