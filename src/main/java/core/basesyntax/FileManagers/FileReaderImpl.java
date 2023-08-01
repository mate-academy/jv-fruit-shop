package core.basesyntax.FileManagers;

import core.basesyntax.exceptions.FileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> getData(String filePath) {
        File file = new File(filePath);
        List<String> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))){
            String dataLine = reader.readLine();
            while (dataLine != null) {
                dataList.add(dataLine);
                dataLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileException("Can't find file to read ", e);
        } catch (IOException e) {
            throw new FileException("Can't read from file ", e);
        }
        return dataList;
    }
}
