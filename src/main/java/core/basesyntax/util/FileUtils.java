package core.basesyntax.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.ExportData;
import core.basesyntax.Order;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class FileUtils {

    private static final char SEPARATOR = ',';

    private FileUtils() {
    }

    public static List<Order> read(String path) throws IOException {
        Reader reader = new FileReader(path);
        CsvToBean<Order> csv = new CsvToBeanBuilder<Order>(reader)
                .withSeparator(SEPARATOR)
                .withIgnoreLeadingWhiteSpace(true)
                .withType(Order.class)
                .build();
        return csv.parse();
    }

    public static void write(String path, List<ExportData> exportDataList) throws IOException,
            CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter(path);
        StatefulBeanToCsv<ExportData> sbc = new StatefulBeanToCsvBuilder<ExportData>(writer)
                .withSeparator(SEPARATOR)
                .withQuotechar(Character.MIN_VALUE)
                .build();
        sbc.write(exportDataList);
        writer.close();
    }
}
