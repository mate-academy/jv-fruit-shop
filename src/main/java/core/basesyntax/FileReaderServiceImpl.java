package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<List<String>> readFile(String filePath, String separator) {
        String line;
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if (br.readLine() == null) {
                throw new RuntimeException("File is empty");
            }
            while ((line = br.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] str = line.split(separator);
                OrderValidation orderValidation = new OrderValidation();
                orderValidation.toCheckOrder(str);
                for (String dataPieces : str) {
                    row.add(dataPieces);
                }
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        return data;
    }
}
