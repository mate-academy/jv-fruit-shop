package core.basesyntax.parsers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFromCSV {

    public List<String[]> parseFromCSV(String FilePath)  {
        List<String[]> fromCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            br.readLine();
            String line = "";
            while((line = br.readLine()) != null) {
                String[] value = line.split(",");
                fromCSV.add(value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn't exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return fromCSV;
    }
}
