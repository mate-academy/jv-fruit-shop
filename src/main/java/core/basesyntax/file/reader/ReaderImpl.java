package core.basesyntax.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> read(String fileName) {
        List<String> data = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new RuntimeException("File not found in resources: " + fileName);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing file "
                    + fileName + " - can't read file", e);
        }

        return data;
    }
}
