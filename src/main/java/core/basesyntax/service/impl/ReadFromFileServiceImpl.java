package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public List<String> redData(String fromFileName) {
        List<String> dataFromFileList = new ArrayList<>();
        File file = new File(fromFileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                dataFromFileList.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file " + file.getName(), e);
        }
        return dataFromFileList;
    }
}
