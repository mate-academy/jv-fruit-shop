package core.basesyntax.fileworker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class InputOutputReport implements WorkWithReport {

    @Override
    public String readReport(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new
                FileReader((fileName)))) {
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                stringBuilder.append(newLine.toLowerCase()).append(" ");
                newLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File was not found", e);
        } catch (IOException e) {
            throw new RuntimeException("File was not read", e);
        }
        return stringBuilder.toString();
    }

    @Override
    public void writeReport(String report) {
        String fileName = "report.txt";
        File file = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("The file was not written", e);
        }
    }
}
