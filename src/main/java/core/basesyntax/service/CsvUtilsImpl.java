package core.basesyntax.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import core.basesyntax.model.Product;
import core.basesyntax.service.operations.Buy;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.Return;
import core.basesyntax.service.operations.Supply;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CsvUtilsImpl {
    private static final int OPERATION_DATA = 0;
    private static final Map<String, Operation> OPERATIONS = new TreeMap<>();

    {
        OPERATIONS.put("s", new Supply());
        OPERATIONS.put("b", new Buy());
        OPERATIONS.put("r", new Return());
    }

    public boolean processFile(String csvInputFile) {
        ProductParser<Product> productParser = new ProductParserImpl();
        try (CSVReader reader = new CSVReader(new FileReader(csvInputFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[OPERATION_DATA].equals("type")) {
                    continue;
                }
                if (!OPERATIONS.containsKey(line[OPERATION_DATA].trim())) {
                    throw new UnsupportedOperationException("Unsupported operation");
                }
                OPERATIONS.get(line[OPERATION_DATA].trim())
                        .updateStorage(productParser.getProducts(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("No such file for input");
        }
        return true;
    }

    public boolean createReport(String csvOutputFile) {
        ReportCreator reportCreator = new ReportCreator();
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvOutputFile))) {
            writer.writeAll(reportCreator.createReport());
            return true;
        } catch (IOException e) {
            throw new RuntimeException("No such file for output");
        }
    }
}
