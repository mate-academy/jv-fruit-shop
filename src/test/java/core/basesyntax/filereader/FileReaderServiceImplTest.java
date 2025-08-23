package core.basesyntax.filereader;

import static core.basesyntax.model.TypeOfOperation.b;
import static core.basesyntax.model.TypeOfOperation.p;
import static core.basesyntax.model.TypeOfOperation.r;
import static core.basesyntax.model.TypeOfOperation.s;
import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.Operation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class FileReaderServiceImplTest {

    private static final String NAME_OF_TEST_FILE = "DataBase.csv";

    @Test
    void readFromCsvFile_ok() {
        String dataBaseTestArray = "b,orange,124\nb,apple,45\nb,lemon,82\n"
                + "b,banana,157\ns,orange,10\n"
                + "p,apple,4\np,orange,23\ns,lemon,5\np,banana,15\n"
                + "r,lemon,10\nr,orange,2\ns,banana,26";
        Operation o = new Operation();
        o.setTypeOfOperation(b);
        o.setFruit("orange");
        o.setQuantity(124);
        Operation o1 = new Operation();
        o1.setTypeOfOperation(b);
        o1.setFruit("apple");
        o1.setQuantity(45);
        Operation o2 = new Operation();
        o2.setTypeOfOperation(b);
        o2.setFruit("lemon");
        o2.setQuantity(82);
        Operation o3 = new Operation();
        o3.setTypeOfOperation(b);
        o3.setFruit("banana");
        o3.setQuantity(157);
        Operation o4 = new Operation();
        o4.setTypeOfOperation(s);
        o4.setFruit("orange");
        o4.setQuantity(10);
        Operation o5 = new Operation();
        o5.setTypeOfOperation(p);
        o5.setFruit("apple");
        o5.setQuantity(4);
        Operation o6 = new Operation();
        o6.setTypeOfOperation(p);
        o6.setFruit("orange");
        o6.setQuantity(23);
        Operation o7 = new Operation();
        o7.setTypeOfOperation(s);
        o7.setFruit("lemon");
        o7.setQuantity(5);
        Operation o8 = new Operation();
        o8.setTypeOfOperation(p);
        o8.setFruit("banana");
        o8.setQuantity(15);
        Operation o9 = new Operation();
        o9.setTypeOfOperation(r);
        o9.setFruit("lemon");
        o9.setQuantity(10);
        Operation o10 = new Operation();
        o10.setTypeOfOperation(r);
        o10.setFruit("orange");
        o10.setQuantity(2);
        Operation o11 = new Operation();
        o11.setTypeOfOperation(s);
        o11.setFruit("banana");
        o11.setQuantity(26);

        List<Operation> expectedList = new ArrayList<>();

        expectedList.add(o);
        expectedList.add(o1);
        expectedList.add(o2);
        expectedList.add(o3);
        expectedList.add(o4);
        expectedList.add(o5);
        expectedList.add(o6);
        expectedList.add(o7);
        expectedList.add(o8);
        expectedList.add(o9);
        expectedList.add(o10);
        expectedList.add(o11);

        File dataBaseTestFile = new File(NAME_OF_TEST_FILE);
        try {
            dataBaseTestFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.write(dataBaseTestFile.toPath(), dataBaseTestArray.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<Operation> operationsFromMethod = fileReaderService.readFromCsvFile();

        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), operationsFromMethod.get(i));
        }
    }
}
