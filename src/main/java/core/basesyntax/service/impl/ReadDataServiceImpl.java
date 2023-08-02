package core.basesyntax.service.impl;

import core.basesyntax.service.ReadDataService;
import core.basesyntax.util.DataValidator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataServiceImpl implements ReadDataService {
    @Override
    public List<String> readData(String sourceFilePath) {
        List<String> dataFromFileList = new ArrayList<>();
        File file = new File(sourceFilePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                dataFromFileList.add(value);
                value = bufferedReader.readLine();
            }
            DataValidator.validateIsSourceDataEmpty(dataFromFileList);
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file " + file.getName(), e);
        }
        return dataFromFileList;
    }
}
