package core.basesyntax.operations;

import core.basesyntax.interfaces.FileWriter;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileWriterImpl implements FileWriter {

    public void writeNewFile(List<Fruit> fruit) throws IOException {
        List<String> stringFruit = new ArrayList<>();
        for (int i = 0; i < fruit.size(); i++) {
            stringFruit.add(fruit.get(i).getTypeOfFruit());
        }
        Map<String, Long> counted = stringFruit.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        java.io.FileWriter newFile = new java.io.FileWriter("file1.txt");
        newFile.write("fruit,quantity" + "\n");
        Set<Map.Entry<String, Long>> entreis = counted.entrySet();
        for (Map.Entry<String, Long> entry : entreis) {
            newFile.write(entry + "\n");
        }
        newFile.close();
    }
}
