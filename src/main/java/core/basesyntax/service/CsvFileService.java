package core.basesyntax.service;

import core.basesyntax.model.Command;
import core.basesyntax.model.Product;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.PurchaseOperation;
import core.basesyntax.service.operations.ReturnOperation;
import core.basesyntax.service.operations.SupplyOperation;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CsvFileService {
    private static final int OPERATION_DATA = 0;
    private static final Map<String, Operation> OPERATIONS = new TreeMap<>();

    {
        OPERATIONS.put("s", new SupplyOperation());
        OPERATIONS.put("b", new PurchaseOperation());
        OPERATIONS.put("r", new ReturnOperation());
    }

    private CsvFileHandler csvFileHandler = new CsvFileHandler();
    private ProductParser<Product> productParser = new ProductParserImpl();
    private CsvFileWriter csvFileWriter = new CsvFileWriter();

    public boolean runApplication(String csvInputFile, String csvOutputFile) {
        List<Command> commandList = csvFileHandler.processFile(csvInputFile);
        for (Command command : commandList) {
            if (command.getCommand()[OPERATION_DATA].equals("type")) {
                continue;
            }
            if (!OPERATIONS.containsKey(command.getCommand()[OPERATION_DATA].trim())) {
                throw new UnsupportedOperationException("Unsupported operation");
            }
            OPERATIONS.get(command.getCommand()[OPERATION_DATA].trim())
                    .updateStorage(productParser.getProducts(command.getCommand()));
        }
        return csvFileWriter.createReport(csvOutputFile);
    }
}
