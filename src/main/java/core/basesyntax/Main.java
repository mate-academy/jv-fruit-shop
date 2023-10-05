package core.basesyntax;

import static core.basesyntax.model.DataSourceType.CsvFile;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.WriterType;
import core.basesyntax.service.InputReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.ReportWriterServiceFile;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.OperationStrategy;
import core.basesyntax.strategy.operation.OperationStrategyImpl;
import core.basesyntax.strategy.read.InputReaderStrategy;
import core.basesyntax.strategy.read.InputReaderStrategyImpl;
import core.basesyntax.strategy.write.ReportWriterStrategy;
import core.basesyntax.strategy.write.ReportWriterStrategyImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FILE_TXT = "src/main/resources/file.txt";
    private static final String REPORT_TXT = "src/main/resources/report.txt";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationStrategies = getOperationStrategies();
        InputReaderStrategy inputReaderStrategy = new InputReaderStrategyImpl();

        InputReaderService csvFileReaderService = inputReaderStrategy.get(CsvFile);
        List<FruitTransaction> fruitTransactions = csvFileReaderService.readInput(FILE_TXT);

        FruitDao dao = new FruitDaoImpl();
        fruitTransactions.forEach(dao::putTransaction);

        ReportGeneratorService reportGenerator
                = new ReportGeneratorServiceImpl(operationStrategies);
        final List<String> report = reportGenerator.generateReport(dao);
        final Map<Fruit, Integer> balance = reportGenerator.generateBalance(dao);
        dao.saveBalance(balance);

        ReportWriterStrategy reportWriterStrategy = new ReportWriterStrategyImpl();
        final ReportWriterService consoleWriter = reportWriterStrategy.get(WriterType.CONSOLE);
        consoleWriter.writeReport(report);

        final ReportWriterService fileWriter = reportWriterStrategy.get(WriterType.FILE);
        ((ReportWriterServiceFile) fileWriter).setFileName(REPORT_TXT);
        fileWriter.writeReport(report);
    }

    private static Map<Operation, OperationHandler> getOperationStrategies() {
        Map<Operation, OperationHandler> strategies = new HashMap<>();
        final OperationStrategy strategy = new OperationStrategyImpl();
        Arrays.stream(Operation.values())
                        .forEach(operation -> strategies.put(operation, strategy.get(operation)));
        return strategies;
    }
}
