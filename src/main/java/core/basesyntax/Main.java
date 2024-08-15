package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String REPORT_FILE_PATH_TO_READ = "src/main/resources/reportToRead.csv";
    public static final String REPORT_FILE_PATH_TO_WRITE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader
                .readFromFile(REPORT_FILE_PATH_TO_READ);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, REPORT_FILE_PATH_TO_WRITE);
    }
}
