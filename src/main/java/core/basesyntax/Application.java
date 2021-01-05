package core.basesyntax;

import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationWithFruits;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitsAdditionImpl;
import core.basesyntax.service.impl.FruitsReductionImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String REPORT_FROM = "example_OK.csv";
    private static final String REPORT_TO = "Final_balance.csv";

    public static void main(String[] args) {
        Map<Operations, OperationWithFruits> operationMap = new HashMap<>();
        operationMap.put(Operations.BALANCE, new FruitsAdditionImpl());
        operationMap.put(Operations.SUPPLY, new FruitsAdditionImpl());
        operationMap.put(Operations.PURCHASE, new FruitsReductionImpl());
        operationMap.put(Operations.RETURN, new FruitsAdditionImpl());

        DataReader dataReader = new CsvFileReaderImpl();
        List<Transaction> transactionList = dataReader.read(REPORT_FROM);
        FruitService service = new FruitServiceImpl(operationMap);
        service.chooseStrategy(transactionList);
        DataWriter dataWriter = new CsvFileWriterImpl();
        dataWriter.write(service.storage(), REPORT_TO);
    }
}
