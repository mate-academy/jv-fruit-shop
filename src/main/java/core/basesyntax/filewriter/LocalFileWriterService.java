package core.basesyntax.filewriter;

import core.basesyntax.FruitStoreDao;
import core.basesyntax.InputDataModel;
import core.basesyntax.exception.FileWritingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LocalFileWriterService implements FileWriterServise {
    private FruitStoreDao fruitStoreDao = new FruitStoreDao();

    @Override
    public void writeFile(String filePath) {
        List<String> fruitsInStorageList = new ArrayList<>();
        fruitsInStorageList.add("fruit,quantity");
        Map<String, Integer> outputData = new LinkedHashMap<>();
        for (Map.Entry<InputDataModel, Integer> entry : fruitStoreDao.getAllFruits().entrySet()) {
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
            throw new FileWritingException("Can't write the file");
        }
    }
}
