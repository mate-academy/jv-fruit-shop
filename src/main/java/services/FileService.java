package services;

import dto.PositionDto;
import interfaces.FileReadable;
import interfaces.FileWritable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import operations.OperationContext;

public class FileService implements FileReadable, FileWritable {

    @Override
    public boolean readFile(String path) {
        List<PositionDto> productsList = new ArrayList<>();
        String line = "";
        OperationContext operationContext = new OperationContext();
        FileParser fileParser = new FileParser();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                PositionDto positionDto = fileParser.parse(line);
                productsList.add(positionDto);
            }
            operationContext.operateSwitcher(productsList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        return true;
    }

    @Override
    public void writeFile(String content, String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(content);
            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Can not write to file");
        }
    }
}
