package core.basesyntax.handler;

import core.basesyntax.model.Fruit;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvFileProcessor implements FileProcessor {

    private static final int ACTION_NAME = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int EXPIRATION_DATE = 3;
    private static final String RESULT_CSV_NAME = "result.csv";

    @Override
    public List<Request> read(String fileName) {
        List<Request> data = new ArrayList<>();
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        try (Reader in = new FileReader(file)) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL
                    .withHeader("type", "fruit", "quantity", "date")
                    .withFirstRecordAsHeader()
                    .parse(in);

            for (CSVRecord record : records) {
                data.add(buildRequests(record));
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file");
        }

        return data;
    }

    @Override
    public String write(List<String> data) {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("fruit", "quantity");
        List<List<String>> rows = data.stream()
                .map(s -> s.split(","))
                .map(Arrays::asList)
                .collect(Collectors.toList());

        try (CSVPrinter printer = new CSVPrinter(new FileWriter(RESULT_CSV_NAME), format)) {
            printer.printRecords(rows);
            return RESULT_CSV_NAME;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with writing to file");
        }
    }

    private Request buildRequests(CSVRecord record) {
        return new Request(record.get(ACTION_NAME),
                Integer.parseInt(record.get(QUANTITY)),
                new Fruit(record.get(FRUIT_NAME),
                        LocalDate.parse(record.get(EXPIRATION_DATE))));
    }
}
