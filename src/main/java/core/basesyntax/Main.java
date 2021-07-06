package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitReport;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitReportImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationsHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/shop_information_csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/report_information_csv";

    public static void main(String[] args) {
        Map<String, OperationsHandler> handlerOperations = new HashMap<>();
        handlerOperations.put("b", new BalanceOperationHandler());
        handlerOperations.put("p", new PurchaseOperationHandler());
        handlerOperations.put("s", new SupplyOperationHandler());
        handlerOperations.put("r", new SupplyOperationHandler());

        FileReader reader = new FileReaderImpl();
        List<String> infoFromFile = reader.readFromFile(PATH_TO_INPUT_FILE);

        Parser parser = new ParserImpl();
        List<FruitDto> fruitDtos = parser.parseAndValidateLines(infoFromFile);
        for (FruitDto fruitDto : fruitDtos) {
            OperationsHandler handler = handlerOperations.get(fruitDto.getOperation());
            handler.apply(fruitDto);
        }

        FruitReport report = new FruitReportImpl();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report.getReport(), PATH_TO_OUTPUT_FILE);
    }
}
