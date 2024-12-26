package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDataImpl implements WriteData {

    private String newPath;

    @Override
    public File writeData(List<String> fruitData) {
        File file = new File(newPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();

            for (String fruit : fruitData) {
                bufferedWriter.write(fruit); // Записуємо інформацію про фрукт
                bufferedWriter.newLine(); // Додаємо новий рядок після кожного запису
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
