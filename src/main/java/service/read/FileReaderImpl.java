package service.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String[]> read(String filePath) {
        File file = new File(filePath);
        List<String> storageInformationList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                storageInformationList.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.");
        }
        return storageInformationList.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());
    }

}
