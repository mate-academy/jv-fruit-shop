package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.filereader.FileReader;
import core.basesyntax.filereader.FileReaderImpl;
import core.basesyntax.filewriter.FileWriter;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.BalanceOperation;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperation;
import core.basesyntax.handlers.ReturnOperation;
import core.basesyntax.handlers.SupplyOperation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        final FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFromFile("reportToRead.csv");

        final DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertFromStrings(inputReport);

        final FruitsDao dao = new FruitsDaoImpl();

        final Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation(dao));
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation(dao));
        operationHandlers.put(Operation.RETURN, new ReturnOperation(dao));
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation(dao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        final ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        final ReportGenerator reportGenerator = new ReportGeneratorImpl(dao);
        final String resultingReport = reportGenerator.getReport();

        final FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(resultingReport, "finalReport.csv");
    }
}
