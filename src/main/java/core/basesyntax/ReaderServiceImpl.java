package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean skipFirstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read file from: " + filePath, e);
        }
        return data;
    }
}
