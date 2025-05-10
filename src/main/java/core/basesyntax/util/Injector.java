package core.basesyntax.util;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.reader.FileReaderImpl;
import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.file.writer.FileWriterImpl;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceOperationHandler;
import core.basesyntax.handler.impl.PurchaseOperationHandler;
import core.basesyntax.handler.impl.ReturnOperationHandler;
import core.basesyntax.handler.impl.SupplyOperationHandler;
import core.basesyntax.model.Operation;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    public static FruitShopService getFruitShopService() {
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileReader fileReader = new FileReaderImpl();
        FileWriter fileWriter = new FileWriterImpl();

        return new FruitShopServiceImpl(fileReader, fileWriter, dataConverter,
                operationStrategy, reportGenerator);
    }
}
