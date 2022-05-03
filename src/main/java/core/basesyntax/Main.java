package core.basesyntax;

import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriteImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import core.basesyntax.service.strategy.TransactionStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH = new StringBuilder("src" + File.separator
                                          + "main" + File.separator
                                          + "resources" + File.separator
                                          + "inputData.csv").toString();
    public static final String OUTPUT_PATH = new StringBuilder("src" + File.separator
                                          + "main" + File.separator
                                          + "resources" + File.separator
                                          + "outputData.csv").toString();

    public static void main(String[] args) {
        Reader dataReader = new ReaderImpl();
        List<String> dataFromFile = dataReader.readFromFile(INPUT_PATH);
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl(validator);
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new SupplyOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        operationHandlerMap.put("b", new BalanceOperation());
        operationHandlerMap.put("p", new PurchaseOperationHandler());

        TransactionStrategy operationStrategy = new TransactionStrategyImpl(operationHandlerMap);

        List<LineData> lineData = parser.parse(dataFromFile);
        for (LineData line : lineData) {
            OperationHandler operationHandler = operationStrategy.get(line);
            operationHandler.operate(line);
        }
        String finalReport = new ReportMakerImpl().createNewReport();

        Writer writer = new WriteImpl();
        writer.writeData(finalReport, OUTPUT_PATH);
    }
}
