package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {

    public static void createFile() {
        String fileName = "/Users/Test_user/IdeaProjects/jv-fruit-shop/reportToRead.csv";

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            // Записываем в файл некоторые данные
            writer.println("type,fruit,quantity");
            writer.println("b,banana,20");
            writer.println("s,banana,100");
            writer.println("p,banana,13");
            writer.println("r,banana,10");

            System.out.println("Файл успешно создан: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

