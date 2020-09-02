package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileWriterImpl {
    Parser parser = new Parser();

    public void writeNewFile(List<Fruit> fruit) throws IOException {
        Map<String, Long> counted = parser.parseToMap(fruit);
        FileWriter newFile = new FileWriter("file1.txt");
        newFile.write("fruit,quantity" + "\n");
        Set<Map.Entry<String, Long>> entreis = counted.entrySet();
        for (Map.Entry<String, Long> entry : entreis) {
            newFile.write(entry + "\n");
        }
        newFile.close();
    }
}
