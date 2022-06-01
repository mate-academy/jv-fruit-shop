package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRadServiceImpl implements FileRadService {
    @Override
    public List<String> readCsv(String readfilepath) {
        String csvline;
        List<String> csvfilelist = new ArrayList<>();
        try(BufferedReader csvBufferedReader = new BufferedReader(new FileReader(readfilepath))) {
            while ((csvline = csvBufferedReader.readLine()) != null) {
                csvfilelist.add(csvline);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file" , e);
        }
        return csvfilelist;
    }
}
