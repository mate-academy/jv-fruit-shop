package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateNewFile implements core.basesyntax.interfaces.CreateNewFile<String> {

    @Override
    public void createNewFile(List<String> fruit) throws IOException {
        FileWriter newFile = new FileWriter("file1.txt");
        newFile.write("fruit,quantity" + "\n");
        String s;
        for (int i = 0; i < fruit.size(); i++) {
            s = fruit.get(i).split(",")[1] + ",";
            s = s + fruit.get(i).split(",")[2];
            newFile.write(s + "\n");
        }
        newFile.close();
    }
}
