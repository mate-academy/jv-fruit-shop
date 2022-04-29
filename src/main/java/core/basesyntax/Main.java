package core.basesyntax;

import core.basesyntax.model.LineInformation;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.WriteDataImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH
            = "src/main/resources/inputData.csv";
    public static final String OUTPUT_PATH
            = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        Reader dataReader = new ReaderImpl();
        List<String> dataFromFile = dataReader.readFile(INPUT_PATH);
        DataValidator dataValidator = new DataValidatorImpl();
        Parser parser = new ParserImpl(dataValidator);
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        List<LineInformation> lineInformations = parser.parse(dataFromFile);
        for (LineInformation lineInformation: lineInformations) {
            OperationHandler operationHandler = operationStrategy.get(lineInformation);
            operationHandler.operate(lineInformation);
        }
        List<String> finalReport = new ReportImpl().createNewReport();

        DataWriter dataWriter = new WriteDataImpl();
        dataWriter.writeData(finalReport, OUTPUT_PATH);
    }
}
