package core.basesyntax;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.FruitOperationDaoImpl;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.report.convertdata.DataConvertor;
import core.basesyntax.report.convertdata.DataConvertorImpl;
import core.basesyntax.report.input.FileReaderImpl;
import core.basesyntax.report.input.Reader;
import core.basesyntax.report.output.FileWriterImpl;
import core.basesyntax.report.output.Writer;
import core.basesyntax.report.report.ReportGenerator;
import core.basesyntax.report.report.ReportGeneratorImpl;
import core.basesyntax.service.AppMainService;
import core.basesyntax.service.AppMainServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {
        Map<FruitOperation.Operation, OperationHandler> handlers = Map.of(
                FruitOperation.Operation.BALANCE, new BalanceOperationHandler(),
                FruitOperation.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitOperation.Operation.RETURN, new ReturnOperationHandler(),
                FruitOperation.Operation.SUPPLY, new SupplyOperationHandler()
        );

        // Prepare services
        Reader reader = new FileReaderImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        FruitOperationDao dao = new FruitOperationDaoImpl();
        ShopService shopService = new ShopServiceImpl(dao, strategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        Writer writer = new FileWriterImpl();

        // Inject dependencies into ApplicationService
        AppMainService appService = new AppMainServiceImpl(
                reader, dataConvertor, shopService, reportGenerator, writer
        );

        // Run the application
        appService.run();

    }
}
