package core.basesyntax;

import core.basesyntax.record.Operation;
import core.basesyntax.record.Record;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.FruitRecordMapper;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportGenerator;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.SupplyOperation;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.RecordMapperStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.RecordMapperStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Reader READER = new ReaderImpl();
    private static final core.basesyntax.service.ReportGenerator REPORT = new ReportGenerator();
    private static final Writer WRITER = new WriterImpl();
    private static final String PATH_FROM_FILE = "src/main/resources/Activity.csv";
    private static final String PATH_TO_FILE = "src/main/resources/Report.csv";
    private static final int NAMES_OF_COLUMNS = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final String COMMA = ",";
    private static RecordMapperStrategy recordMapperStrategy;
    private static OperationStrategy operationStrategy;

    public static void main(String[] args) {
        strategyInitializer();

        List<String> linesFromFile = READER.getLinesFromFile(PATH_FROM_FILE);

        List<Record> recordsFromLines = recordMapperStrategy
                .get(getProductType(linesFromFile))
                .getRecordsFromLines(linesFromFile);

        recordsFromLines
                .forEach(record -> operationStrategy.get(record.operation()).operate(record));

        String report = REPORT.generateReport();

        WRITER.putDataToFile(report, PATH_TO_FILE);
    }

    private static String getProductType(List<String> linesFromFile) {
        String[] namesOfColumns = linesFromFile.remove(NAMES_OF_COLUMNS).split(COMMA);
        return namesOfColumns[PRODUCT_INDEX];
    }

    private static void strategyInitializer() {
        recordMapperStrategy = new RecordMapperStrategyImpl(Map
                .of("fruit", new FruitRecordMapper()));
        operationStrategy = new OperationStrategyImpl(Map
                .of(Operation.BALANCE, new BalanceOperation(),
                        Operation.RETURN, new ReturnOperation(),
                        Operation.PURCHASE, new PurchaseOperation(),
                        Operation.SUPPLY, new SupplyOperation()));
    }
}
