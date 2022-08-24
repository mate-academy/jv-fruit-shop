package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.ReportBuilderImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import java.util.List;

public class FruitShopApp {
    private TransactionParser parser = new TransactionParserImpl();
    private ReportBuilder reportBuilder = new ReportBuilderImpl();
    private FruitDao dao = new FruitDaoImpl();

    public static void main(String[] args) {
        FruitShopApp app = new FruitShopApp();
        List<FruitTransaction> fruitTransactions = app.parser.getTransactions("transactions.csv");
        List<String> report = app.reportBuilder.getReport(fruitTransactions);
        app.dao.writeReport("report.csv", report);
    }
}
