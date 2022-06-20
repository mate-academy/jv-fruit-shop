package core.basesyntax;

import core.basesyntax.modelfruit.ModelFruit;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.Balance;
import core.basesyntax.service.ParceData;
import core.basesyntax.service.PrepareReport;
import core.basesyntax.service.ReadFile;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.actiontype.ActionStrategyBalance;
import core.basesyntax.service.actiontype.ActionStrategyProducer;
import core.basesyntax.service.actiontype.ActionStrategyReturner;
import core.basesyntax.service.actiontype.ActionStrategySupplier;
import core.basesyntax.service.actiontype.ActionType;
import core.basesyntax.service.impl.ActionStrategyImpl;
import core.basesyntax.service.impl.BalancePerDay;
import core.basesyntax.service.impl.ParceDataImpl;
import core.basesyntax.service.impl.PrepareReportImpl;
import core.basesyntax.service.impl.ReadFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_ACTION_PER_DAY = "src"
            + File.separator + "main" + File.separator
            + "resources" + File.separator + "ActionsPerDay.csv";
    private static final String FILE_REPORT_PER_DAY = "src"
            + File.separator + "main" + File.separator
            + "resources" + File.separator + "ReportPerDay.csv";
    private static final Map<String, ActionType> mapStrategy = new HashMap<>();

    public static void main(String[] args) {
        mapStrategy.put("b", new ActionStrategyBalance());
        mapStrategy.put("p", new ActionStrategyProducer());
        mapStrategy.put("s", new ActionStrategySupplier());
        mapStrategy.put("r", new ActionStrategyReturner());
        ActionStrategy actionStrategy = new ActionStrategyImpl(mapStrategy);

        ReadFile readFile = new ReadFileImpl();
        List<String> inputValues = readFile.getData(FILE_ACTION_PER_DAY);

        ParceData parceFruitMoving = new ParceDataImpl();
        List<ModelFruit> fruitsMoving = parceFruitMoving.getFruitsMoving(inputValues);

        Balance getBalance = new BalancePerDay();
        getBalance.calculateBalance(fruitsMoving, actionStrategy);

        PrepareReport prepareReport = new PrepareReportImpl();
        String stringReport = prepareReport.makeReport();

        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeReportToFile(stringReport, FILE_REPORT_PER_DAY);
        System.out.println("Report was written to file: " + FILE_REPORT_PER_DAY);
    }
}
