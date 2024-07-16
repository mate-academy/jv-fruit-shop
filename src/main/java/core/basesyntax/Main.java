package core.basesyntax;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DeepCopy;
import core.basesyntax.service.FruitList;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.DeepCopyImpl;
import core.basesyntax.service.impl.FruitListImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileInputPath = "src/main/resources/inputFile.csv";
        final String fileOutputPath = "src/main/resources/outputFile.csv";

        ReaderService readerService = new ReaderServiceImpl();
        List<String> list = readerService.readFile(fileInputPath);
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> listOfAll = dataConverter.convertListToObjects(list);
        FruitList fruitList = new FruitListImpl();
        List<FruitTransaction> listOfOnlyFruits = fruitList.getFruitList(listOfAll);

        OperationHandler balanceHandler = new BalanceHandler();
        OperationHandler supplyHandler = new SupplyHandler();
        OperationHandler purchaseHandler = new PurchaseHandler();
        OperationHandler returnHandler = new ReturnHandler();

        DeepCopy deepCopy = new DeepCopyImpl();

        List<FruitTransaction> balanceList = balanceHandler
                .getFruitFinalQuantity(deepCopy.getDeepCopy(listOfAll),
                        deepCopy.getDeepCopy(listOfOnlyFruits));
        List<FruitTransaction> supplyList = supplyHandler
                .getFruitFinalQuantity(deepCopy.getDeepCopy(listOfAll),
                        deepCopy.getDeepCopy(listOfOnlyFruits));
        List<FruitTransaction> purchaseList = purchaseHandler
                .getFruitFinalQuantity(deepCopy.getDeepCopy(listOfAll),
                        deepCopy.getDeepCopy(listOfOnlyFruits));
        List<FruitTransaction> returnList = returnHandler
                .getFruitFinalQuantity(deepCopy.getDeepCopy(listOfAll),
                        deepCopy.getDeepCopy(listOfOnlyFruits));

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<FruitTransaction> reportList = reportGenerator
                .generateReport(deepCopy.getDeepCopy(balanceList),
                        deepCopy.getDeepCopy(supplyList),
                        deepCopy.getDeepCopy(purchaseList),
                        deepCopy.getDeepCopy(returnList));
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToCsv(reportList, fileOutputPath);
    }
}
