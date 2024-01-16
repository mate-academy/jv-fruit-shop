package core.basesyntax.main;

import core.basesyntax.dao.CsvFileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.impl.CsvReporterServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationProvider;
import core.basesyntax.service.operation.OperationProvider;
import core.basesyntax.service.operation.PurchaseOperationProvider;
import core.basesyntax.service.operation.ReturnOperationProvider;
import core.basesyntax.service.operation.SupplyOperationProvider;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static OperationStrategy operationStrategy;

    private static void putStrategies() {
        Map<FruitTransaction.Operation, OperationProvider> operationProviderMap = new HashMap<>();
        operationProviderMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationProvider());
        operationProviderMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationProvider());
        operationProviderMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationProvider());
        operationProviderMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationProvider());
        operationStrategy = new OperationStrategyImpl(operationProviderMap);
    }

    public static void main(String[] args) {
        File fitFileToRead = new File(
                "src/main/java/core/basesyntax/Main/Resources/DefaultFile.csv");
        File fileToWrite = new File("toWrite.csv");
        putStrategies();
        writeToFileCsv(fitFileToRead, fileToWrite);
    }

    private static void writeToFileCsv(File fileToRead, File fileToWrite) {
        if (!fileToRead.exists()) {
            throw new RuntimeException("Non-valid path to file");
        }
        try {
            fileToWrite.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file");
        }
        List<String> csvFileToList = new CsvFileReaderImpl().get(fileToRead);
        Map<String, BigDecimal> csvMapToWrite = new HashMap<>();
        csvMapToWrite = new CsvReporterServiceImpl(csvMapToWrite, operationStrategy)
                .get(csvFileToList);
        new CsvWriterServiceImpl().write(fileToWrite, csvMapToWrite);
    }
}
