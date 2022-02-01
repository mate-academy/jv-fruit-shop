package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.OperationHendler;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataProcessImpl;
import core.basesyntax.service.impl.OperationHendlerBalance;
import core.basesyntax.service.impl.OperationHendlerPurchase;
import core.basesyntax.service.impl.OperationHendlerReturn;
import core.basesyntax.service.impl.OperationHendlerSupply;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";

        FruitDaoImpl fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, OperationHendler> operationHendlerMap = new HashMap<>();
        operationHendlerMap.put(FruitTransaction.Operation.BALANCE,
                                            new OperationHendlerBalance());
        operationHendlerMap.put(FruitTransaction.Operation.PURCHASE,
                                            new OperationHendlerPurchase());
        operationHendlerMap.put(FruitTransaction.Operation.RETURN,
                                            new OperationHendlerReturn());
        operationHendlerMap.put(FruitTransaction.Operation.SUPPLY,
                                            new OperationHendlerSupply());

        List<String> dataFromFile = new CsvReaderServiceImpl().readFile(inputFilePath);
        List<FruitTransaction> parseredData = new DataParserImpl().parsingData(dataFromFile);
        DataProcess dataProcess = new DataProcessImpl(fruitDao, operationHendlerMap);
        dataProcess.processingData(parseredData);

        String report = new ReportGeneratorImpl(fruitDao).generateReport();

        String reportFilePath = "src/main/resources/report.csv";
        new CsvWriterServiceImpl().writeToFile(reportFilePath, report);
    }
}
