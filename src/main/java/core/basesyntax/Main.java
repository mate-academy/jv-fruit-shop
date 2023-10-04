package core.basesyntax;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.fileservices.FileParser;
import core.basesyntax.service.fileservices.FileReader;
import core.basesyntax.service.fileservices.FileReaderImpl;
import core.basesyntax.service.fileservices.Writer;
import core.basesyntax.service.fileservices.WriterImpl;
import core.basesyntax.service.operationhadler.BalanceHandler;
import core.basesyntax.service.operationhadler.PurchaseHandler;
import core.basesyntax.service.operationhadler.ReturnHandler;
import core.basesyntax.service.operationhadler.SupplyHandler;
import core.basesyntax.service.operationhadler.TransactionHandler;
import core.basesyntax.service.summaryofoperations.PreparationReportList;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources" + "/FruitFiles.csv";
    private static final String reportFilePath = "src/main/resources" + "/reportFiles/report.csv";

    public static void main(String[] args) {
        Map<FruitsTransaction.Operation, TransactionHandler> operationStrategyMap =
                Map.of(FruitsTransaction.Operation.BALANCE, new BalanceHandler(),
                        FruitsTransaction.Operation.PURCHASE, new PurchaseHandler(),
                        FruitsTransaction.Operation.SUPPLY, new SupplyHandler(),
                        FruitsTransaction.Operation.RETURN, new ReturnHandler());
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromFile = fileReader.readFromCsvFile(inputFilePath);
        FileParser fileParser = new FileParser();
        List<FruitsTransaction> operationList = fileParser.parseData(dataFromFile);
        FruitShop fruitShop = new FruitShop(new StrategyImpl(operationStrategyMap));
        fruitShop.processOfOperations(operationList);
        PreparationReportList preparationReportList = new PreparationReportList();
        String dataForReport = preparationReportList.reportPreparation();
        Writer writer = new WriterImpl();
        writer.writeData(dataForReport, reportFilePath);
    }
}
