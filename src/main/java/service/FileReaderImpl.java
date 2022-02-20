package service;

import dao.FruitRecordDaoUseFileImpl;
import java.io.BufferedReader;
import java.io.IOException;
import model.FruitRecordDto;

public class FileReaderImpl implements FileReader {
    @Override
    public boolean read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                FruitRecordDto fruitRecordDto = new FruitRecordDtoParserFromFileImpl().parse(line);
                new FruitRecordDaoUseFileImpl().add(fruitRecordDto);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("cannot read the file, check the file path" + path);
        }
        return true;
    }
}
