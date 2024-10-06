package core.basesyntax;

import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.io.FileWriter;
import core.basesyntax.io.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.servise.*;
import core.basesyntax.servise.operation.*;

import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String DIRECTORY_PATH = "./src/main/java/core/basesyntax";
    private static final String INPUT_FILE_PATH = DIRECTORY_PATH + "/transactions.csv";
    private static final String OUTPUT_FILE_PATH = "finalReport.csv";
    public static void main(String[] args){
        FileReader fileReader = new FileReaderImpl();
        List<String> inputData = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);

        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService.getStorage());
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
