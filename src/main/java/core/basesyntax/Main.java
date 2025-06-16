package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.io.FileWriter;
import core.basesyntax.io.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        FruitDao fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitDao);
        FileWriter fileWriter = new FileWriterImpl();

        List<String> inputReport = fileReader.read(INPUT_FILE);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);

        String resultingReport = reportGenerator.getReport();
        fileWriter.write(resultingReport, OUTPUT_FILE);
    }
}
