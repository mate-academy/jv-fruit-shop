package services;

import dto.FruitDto;
import interfaces.FileReaderInterface;
import interfaces.FileWriterInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import operations.OperationContext;

public class FileService implements FileReaderInterface, FileWriterInterface {
    private static final String FILE_PATH_TO_WRITE_RESULT = "src/test/java/results/result.txt";

    @Override
    public void readFile(String path) {
        String line = "";
        OperationContext operationContext;
        FileParser fileParser = new FileParser();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                FruitDto fruitDto = fileParser.parse(line);
                operationContext = new OperationContext();
                operationContext.operateSwitcher(fruitDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String content) {
        try (FileWriter writer = new FileWriter(FILE_PATH_TO_WRITE_RESULT, false)) {
            writer.write(content);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
