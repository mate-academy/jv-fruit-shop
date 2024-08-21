package core.basesyntax;

import core.basesyntax.io.CustomFileWriter;
import core.basesyntax.io.CustomFileWriterImpl;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.service.BalanceOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.PurchaseOperation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ReturnOperation;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DIRECTORY_PATH = "./src/main/java/core/basesyntax";
    private static final String INPUT_FILE_PATH = DIRECTORY_PATH + "/1some.csv";
    private static final String OUTPUT_FILE_PATH = "./src/main/resources/finalReport.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);
        DataConverter dataConverter = new DataConverterImpl();
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService);
        String resultingReport = reportGenerator.getReport();

        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
