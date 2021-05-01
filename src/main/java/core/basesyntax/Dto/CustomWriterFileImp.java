package core.basesyntax.Dto;

import core.basesyntax.Model.Fruit;
import core.basesyntax.Model.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CustomWriterFileImp implements CustomWriterFile {
    @Override
    public void writeFile(String nameFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile))) {
            bufferedWriter.append("fruit").append(", ").append("quantity")
                    .append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> fruitEntry : Storage.fruits.entrySet()) {
                bufferedWriter.append(fruitEntry.getKey().getName())
                        .append(", ").append(String.valueOf(fruitEntry.getValue()))
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
    }
}
