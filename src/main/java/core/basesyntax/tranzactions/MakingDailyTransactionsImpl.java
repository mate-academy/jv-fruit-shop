package core.basesyntax.tranzactions;

import core.basesyntax.gettingreport.GetFromReportImpl;
import java.util.List;

public class MakingDailyTransactionsImpl implements MakingDailyTransactions {
    @Override
    public void makeAllTransactions(String fromFile) {
        GetFromReportImpl report = new GetFromReportImpl();
        DefineTheTransaction definition = new DefineTheTransaction();
        List<String> fromReport = report.getFromReport(fromFile);
        for (String lines : fromReport) {
            String[] split = lines.split(",");
            definition.definition(split[0],split[1],Integer.valueOf(split[2]));
        }
    }
}
