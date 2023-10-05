package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitShopService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.impl.operationhadler.BalanceHandler;
import core.basesyntax.service.impl.operationhadler.PurchaseHandler;
import core.basesyntax.service.impl.operationhadler.ReturnHandler;
import core.basesyntax.service.impl.operationhadler.SupplyHandler;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources/FruitFiles.csv";
    private static final String reportFilePath = "src/main/resources/reportFiles/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnHandler());
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> dataFromFile = fileReader.readFromCsvFile(inputFilePath);
        ParserServiceImpl fileParser = new ParserServiceImpl();
        List<FruitTransaction> operationList = fileParser.parseData(dataFromFile);
        FruitShopService fruitShop =
                new FruitShopService(new OperationStrategyImpl(
                        operationStrategyMap));
        fruitShop.processOfOperations(operationList);
        ReportServiceImpl preparationReportList = new ReportServiceImpl();
        String dataForReport = preparationReportList.reportPreparation();
        WriterService writer = new WriterServiceImpl();
        writer.writeData(dataForReport, reportFilePath);
    }
}
