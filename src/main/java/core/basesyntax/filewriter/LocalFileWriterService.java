package core.basesyntax.filewriter;

import core.basesyntax.exception.FileWritingException;
import core.basesyntax.model.InputDataModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LocalFileWriterService implements FileWriterService {
    public static final String HEADER = "fruit,quantity";

    @Override
    public void writeFile(Map<InputDataModel, Integer> storage, String filePath) {
        List<String> fruitsInStorageList = new ArrayList<>();
        fruitsInStorageList.add(HEADER);
        Map<String, Integer> outputData = new LinkedHashMap<>();
        if (storage == null) {
            throw new RuntimeException("Fruit store warehouse is empty");
        }
        for (Map.Entry<InputDataModel, Integer> entry : storage.entrySet()) {
            if (outputData.containsKey(entry.getKey().getName())) {
                outputData.compute(entry.getKey().getName(), (f, a) -> a + entry.getValue());
            } else {
                outputData.put(entry.getKey().getName(), entry.getValue());
            }
        }
        for (Map.Entry<String, Integer> entry : outputData.entrySet()) {
            fruitsInStorageList.add(entry.getKey() + "," + entry.getValue());
        }
        try {
            Files.write(Paths.get(filePath), fruitsInStorageList);
        } catch (IOException e) {
            throw new FileWritingException("Can't write the file", e);
        }
    }
}
