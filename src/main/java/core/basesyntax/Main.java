package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.Instruction;
import core.basesyntax.service.OperationExecutor;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.OperationExecutorImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/file.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        Map<FruitOperation, Operation> operationsHandlers = Map.of(
                FruitOperation.BALANCE, new BalanceOperation(storageDao),
                FruitOperation.SUPPLY, new SupplyOperation(storageDao),
                FruitOperation.PURCHASE, new PurchaseOperation(storageDao),
                FruitOperation.RETURN, new ReturnOperation(storageDao)
        );
        Reader reader = new ReaderImpl();
        Parser parser = new ParserImpl();
        OperationExecutor operationExecutor = new OperationExecutorImpl(operationsHandlers);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(new StorageDaoImpl());
        Writer writer = new WriterImpl(reportGenerator);
        List<String> lines = reader.read(INPUT_FILE);
        List<Instruction> transactions = parser.parse(lines);
        operationExecutor.proceedAll(transactions);
        writer.createReport(OUTPUT_FILE);
    }
}
