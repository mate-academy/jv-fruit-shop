package core.basesyntax.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.model.Operation;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final int DATE_POSITION = 3;

    public List<Operation> readFile(String filepath) {
        List<Operation> operationList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            if (!filepath.toLowerCase().endsWith(".csv")) {
                throw new RuntimeException("File is not in .csv format");
            }
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> rows = csvReader.readAll();
            if (rows.get(0)[0].equals("type")) {
                rows.remove(0);
            }
            for (String[] row : rows) {
                operationList.add(new Operation(row[OPERATION_POSITION], row[FRUIT_POSITION],
                        Integer.parseInt(row[QUANTITY_POSITION]),
                        LocalDate.parse(row[DATE_POSITION])));
            }

        } catch (IOException e) {
            throw new RuntimeException("Some problems with file reading");

        } catch (CsvException e) {
            System.out.println("File does not have csv structure");
        }

        return operationList;
    }
}
