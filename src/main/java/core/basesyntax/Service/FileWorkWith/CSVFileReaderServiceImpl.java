package core.basesyntax.Service.FileWorkWith;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderServiceImpl implements CSVFileReaderService {
    @Override
    public List<String[]> readFile(String readFromFilePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(readFromFilePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        }catch (IOException e) {
            throw new RuntimeException("can't find file or read from this path: "
                    + readFromFilePath, e);
        }
        return data;
    }
}
