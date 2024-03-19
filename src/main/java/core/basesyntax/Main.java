package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderCsv;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ReportWriterCsv;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.DecreaseStrategy;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.IncreaseStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATHNAME = "src/main/resources/data.csv";
    private static final String REPORT_PATHNAME = "src/main/resources/report.csv";
    private static Map<Operation, OperationHandler> strategyMap;

    public static void main(String[] args) {
        DataReader dataReader = new DataReaderCsv();
        List<String> readFile = dataReader.read(INPUT_PATHNAME);

        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.parseAll(readFile);

        FruitDao fruitDao = new FruitDaoImpl();
        mapBuilder(fruitDao);
        FruitStrategy fruitStrategy = new FruitStrategy(strategyMap);
        fruitStrategy.processData(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(fruitDao.getFruits());

        ReportWriter reportWriter = new ReportWriterCsv();
        reportWriter.writeReport(report, REPORT_PATHNAME);
    }

    private static void mapBuilder(FruitDao fruitDao) {
        strategyMap = Map.of(
                Operation.BALANCE, new BalanceStrategy(fruitDao),
                Operation.PURCHASE, new DecreaseStrategy(fruitDao),
                Operation.SUPPLY, new IncreaseStrategy(fruitDao),
                Operation.RETURN, new IncreaseStrategy(fruitDao)
        );
    }
}
