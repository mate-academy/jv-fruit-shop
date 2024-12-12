package core.basesyntax;

import core.basesyntax.service.*;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();

        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        DataConverter dataConverter = new DataConverterImpl();
        MyFileReader fileReader = new FileReaderImpl();

        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader
                .getResource("toRead.csv")).getFile());
        List<String> inputReport = fileReader.read(file.getPath());

        shopService.process(dataConverter.convertToTransaction(inputReport));

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        MyFileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(finalReport, "src/main/resources/finalReport.csv");
    }
}
