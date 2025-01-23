package core.basesyntax;

import core.basesyntax.dao.CustomFileReader;
import core.basesyntax.dao.CustomFileReaderImpl;
import core.basesyntax.dao.CustomFileWriter;
import core.basesyntax.dao.CustomFileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ReportGenerator;
import core.basesyntax.model.ReportGeneratorImpl;
import core.basesyntax.model.converter.DataConverter;
import core.basesyntax.model.converter.DataConverterImpl;
import core.basesyntax.model.handler.BalanceOperation;
import core.basesyntax.model.handler.OperationHandler;
import core.basesyntax.model.handler.PurchaseOperation;
import core.basesyntax.model.handler.ReturnOperation;
import core.basesyntax.model.handler.SupplyOperation;
import core.basesyntax.model.strategy.OperationStrategy;
import core.basesyntax.model.strategy.OperationStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String REPORT_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {

        CustomFileReader fileReader = new CustomFileReaderImpl();
        List<String> inputReport = fileReader.read(REPORT_TO_READ);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        fileWriter.write(FINAL_REPORT,resultingReport);
    }

}
