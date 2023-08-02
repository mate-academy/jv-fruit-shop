package core.basesyntax.services.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.services.ReadFileService;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public List<String[]> read(String fileName) {
        List<String[]> strLines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                strLines.add(nextLine);
            }
        } catch (IOException e) {
            System.out.println("Cant open the file!");
            e.printStackTrace();
        } catch (CsvValidationException e) {
            System.out.println("CSV file is incorrect!");
            e.printStackTrace();
        }
        return strLines;
    }
}
