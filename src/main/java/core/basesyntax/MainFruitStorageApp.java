package core.basesyntax;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.service.export.ExportService;
import core.basesyntax.service.export.impl.ExportServiceImpl;
import core.basesyntax.util.FileUtils;
import core.basesyntax.util.OrderUtils;
import java.io.IOException;
import java.util.List;

public class MainFruitStorageApp {

    private static final String OUTPUT_FILE = "src/main/resources/result.csv";
    private static final String INPUT_FILE = "src/main/resources/orders.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<Order> orders = FileUtils.read(INPUT_FILE);
        orders.forEach(OrderUtils::processOrder);
        ExportService service = new ExportServiceImpl();
        List<ExportData> exportDataList = service.prepareData();
        FileUtils.write(OUTPUT_FILE, exportDataList);
    }
}
