package core.basesyntax;

import core.basesyntax.record.Operation;
import core.basesyntax.record.Record;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.CommonReportGenerator;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.FruitRecordMapper;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.SupplyOperation;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.RecordMapperStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final ReportGenerator REPORT = new CommonReportGenerator();
    private static final Writer WRITER = new WriterImpl();
    private static final String PATH_FROM_FILE = "src/main/resources/FruitActivity.csv";
    private static final String PATH_TO_FOLDER = "src/main/resources/";

    public static void main(String[] args) {
        initializeStrategies();

        List<String> linesFromFile = new ReaderImpl().readFromFile(PATH_FROM_FILE);
        List<Record> records = new DataConverterImpl().convert(linesFromFile);

        new DataProcessingServiceImpl().processData(records);

        Map<String, String> reports = REPORT.generate();
        WRITER.writeToFolder(reports, PATH_TO_FOLDER);
    }

    private static void initializeStrategies() {
        new RecordMapperStrategyImpl(Map
                .of("fruit", new FruitRecordMapper()));
        new OperationStrategyImpl(Map
                .of(Operation.BALANCE, new BalanceOperation(),
                        Operation.RETURN, new ReturnOperation(),
                        Operation.PURCHASE, new PurchaseOperation(),
                        Operation.SUPPLY, new SupplyOperation()));
    }
}
