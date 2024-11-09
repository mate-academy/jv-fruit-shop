package core.basesyntax;

import core.basesyntax.converter.impl.DataConverter;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.reader.Reader;
import core.basesyntax.reader.ReaderImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.impl.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.writer.Writer;
import core.basesyntax.writer.impl.WriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Reader fileReader = new ReaderImpl();
        List<List<String>> inputReport = fileReader.read("src/main/resources/reportToRead.cvs");

        DataConverter dataConverter = new DataConverter();
        final List<FruitTransaction> dataFromTransaction =
                dataConverter.convertToTransaction(inputReport);
        Map<FruitTransaction.Operation, OperationStrategy> operationHandlers = new HashMap<>();

        Storage storage = new Storage();
        FruitDao fruitDao = new FruitDaoImpl(storage);
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(dataFromTransaction);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        Writer fileWriter = new WriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
