package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.domain.FruitTransaction;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> readLines = fileService.read("fruits.csv");
        DataConverterService dataConverterService = new DataConverterImpl();
        final List<FruitTransaction> convertedFruitTransactions =
                dataConverterService.convertToFruit(readLines);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy, new FruitDaoImpl());
        shopService.process(convertedFruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        String generatedReport = reportService.generateReport();
        fileService.writeToFile(generatedReport, "resultReport.csv");
    }
}
