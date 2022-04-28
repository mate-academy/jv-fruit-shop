package core.basesyntax;

import core.basesyntax.model.LineInformation;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.WriteDataImpl;
import core.basesyntax.service.strategy.BalanceState;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH
            = "src/main/java/core/basesyntax/resources/inputData.csv";
    public static final String OUTPUT_PATH
            = "src/main/java/core/basesyntax/resources/outputData.csv";

    public static void main(String[] args) {
        Reader dataReader = new ReaderImpl();
        List<String> dataFromFile = dataReader.readFile(INPUT_PATH);

        Parser parser = new ParserImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new SupplyOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        operationHandlerMap.put("b", new BalanceState());
        operationHandlerMap.put("p", new PurchaseOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        List<LineInformation> lineInformations = parser.parse(dataFromFile);
        for (LineInformation lineInformation: lineInformations) {
            OperationHandler operationHandler = operationStrategy.get(lineInformation);
            operationHandler.operation(lineInformation);
        }
        List<String> finalReport = new ReportImpl().createNewReport();

        DataWriter dataWriter = new WriteDataImpl();
        dataWriter.writeData(finalReport, OUTPUT_PATH);
    }
}
