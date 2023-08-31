package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String fileName) {
        List<String> stringList = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringList.add(value);
                String[] fruits = value.replaceAll("\\s+", "").split(",");
                Storage.storage.put(fruits[1],0);
                value = bufferedReader.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
        return stringList;
    }
}
