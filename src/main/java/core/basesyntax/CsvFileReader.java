package core.basesyntax;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    public List<Operation> readFile(String filepath) {
        List<Operation> operationList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            if (!filepath.toLowerCase().endsWith(".csv")) {
                throw new RuntimeException("File is not in .csv format");
            }
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> raws = csvReader.readAll();
            if (raws.get(0)[0].equals("type")) {
                raws.remove(0);
            }
            for (String[] raw : raws) {
                operationList.add(new Operation(raw[0], raw[1], Integer.parseInt(raw[2]),
                        LocalDate.parse(raw[3])));
            }

        } catch (IOException e) {
            throw new RuntimeException();

        } catch (CsvException e) {
            System.out.println("File does not have csv structure");
        }

        return operationList;
    }
}
