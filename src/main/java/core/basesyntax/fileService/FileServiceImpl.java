package core.basesyntax.fileService;

import java.io.*;

public class FileServiceImpl implements FileService {

    @Override
    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(System.lineSeparator()).append(stringLine);
            }
            return stringBuilder.toString().trim();
        } catch (IOException ioException) {
            throw new RuntimeException("Can not read this file: " + fileName + ioException);
        }
    }

    @Override
    public void writeToFile(String currentData, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(currentData);
        } catch (IOException ioException) {
            throw new RuntimeException("Can not write this file: " + fileName + ioException);
        }
    }
}
