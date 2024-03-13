package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Convert;
import core.basesyntax.service.ConvertImpl;
import core.basesyntax.service.ReadData;
import core.basesyntax.service.ReadDataImpl;
import core.basesyntax.service.ReportContent;
import core.basesyntax.service.ReportContentImpl;
import core.basesyntax.service.StartingBalance;
import core.basesyntax.service.StartingBalanceImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.service.strategy.OperationProcessor;
import core.basesyntax.service.strategy.OperationProcessorImpl;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final FruitDao dao = new FruitDaoImpl();
    private static final OperationProcessor processor = new OperationProcessorImpl();
    private static final ReadData readData = new ReadDataImpl();
    private static final Convert convert = new ConvertImpl();
    private static final ReportContent reportContent = new ReportContentImpl();
    private static final Writer writer = new WriterImpl();
    private static final StartingBalance startingBalance = new StartingBalanceImpl();
    private static final List<FruitTransaction> infoFromAllFruit = new ArrayList<>();

    public static void main(String[] args) {
        processor.addOperationHandler(Operation.PURCHASE, new PurchaseHandler(dao));
        processor.addOperationHandler(Operation.SUPPLY, new SupplyHandler(dao));
        processor.addOperationHandler(Operation.RETURN, new ReturnHandler(dao));

        infoFromAllFruit.addAll(convert.convertToJavaObject(
                readData.readDataFromFile(
                        "src/main/resources/StartInfo.csv")));

        dao.transferStartBalance(startingBalance.getStartingBalance(
                infoFromAllFruit), infoFromAllFruit);

        for (Operation operation : Operation.values()) {
            processor.processOperation(operation);
        }

        writer.writeRepo(reportContent.generateReportContent(dao.getInfoFromBalance()),
                "src/main/resources/Result.csv");
    }
}
