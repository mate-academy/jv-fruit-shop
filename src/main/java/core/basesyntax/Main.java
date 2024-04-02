package core.basesyntax;

import core.basesyntax.impl.ReadDataLogicImpl;
import core.basesyntax.impl.WriteToFileImpl;
import core.basesyntax.service.ReadDataLogic;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WriteToFileImpl write = new WriteToFileImpl();
        ReadDataLogic read = new ReadDataLogicImpl();
        Map<String, Integer> map = read.readDataFromFile("E:\\IDEA Projects\\jv-fruit-shop\\"
                + "src\\main\\java\\core\\basesyntax\\database\\beginningData");
        write.writeReport("E:\\IDEA Projects\\"
                + "jv-fruit-shop\\src\\main\\java\\core\\basesyntax\\database\\report", map);
    }
}
