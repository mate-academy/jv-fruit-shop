package core.basesyntax.service;

import core.basesyntax.model.Product;
import core.basesyntax.service.operations.Buy;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.Return;
import core.basesyntax.service.operations.Supply;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CsvFileService {
    private static final int OPERATION_DATA = 0;
    private static final Map<String, Operation> OPERATIONS = new TreeMap<>();

    {
        OPERATIONS.put("s", new Supply());
        OPERATIONS.put("b", new Buy());
        OPERATIONS.put("r", new Return());
    }

    private CsvFileHandler csvFileHandler = new CsvFileHandler();
    private ProductParser<Product> productParser = new ProductParserImpl();
    private CsvFileWriter csvFileWriter = new CsvFileWriter();

    public boolean runApplication(String csvInputFile, String csvOutputFile) {
        List<String[]> commandList = csvFileHandler.processFile(csvInputFile);
        for (String[] line : commandList) {
            if (line[OPERATION_DATA].equals("type")) {
                continue;
            }
            if (!OPERATIONS.containsKey(line[OPERATION_DATA].trim())) {
                throw new UnsupportedOperationException("Unsupported operation");
            }
            OPERATIONS.get(line[OPERATION_DATA].trim())
                    .updateStorage(productParser.getProducts(line));
        }
        return csvFileWriter.createReport(csvOutputFile);
    }
}
