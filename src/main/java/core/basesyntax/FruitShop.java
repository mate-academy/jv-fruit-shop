package core.basesyntax;

import dao.RecordDao;
import dao.RecordDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import services.ActionTypeStrategy;
import services.ActionTypeStrategyImpl;
import services.Report;
import services.ReportImpl;
import services.actions.ActionHandler;
import services.actions.BalanceHandler;
import services.actions.IncreaseHandler;
import services.actions.PurchaseHandler;

public class FruitShop {
    public static void main(String[] args) {
        final String fromFileNamePath = "src/main/java/resources/input.txt";
        final String toFileNamePath = "src/main/java/resources/report.txt";

        RecordDao recordDao = new RecordDaoImpl();

        Map<String, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put("b",new BalanceHandler());
        actionHandlerMap.put("s",new IncreaseHandler());
        actionHandlerMap.put("p",new PurchaseHandler());
        actionHandlerMap.put("r",new IncreaseHandler());
        ActionTypeStrategy actionTypeStrategy = new ActionTypeStrategyImpl(actionHandlerMap);

        Report reportService = new ReportImpl(actionTypeStrategy);

        List<String> records = recordDao.readFile(fromFileNamePath);
        String report = reportService.createReport(records);
        recordDao.writeFile(toFileNamePath, report);
    }
}

