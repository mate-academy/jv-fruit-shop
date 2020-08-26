package core.basesyntax.write;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.operation.OperationGeneral;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RecordingService {
    public void writingToFile() {
        OrderDao orderDao = new OrderDaoImpl();



        try (FileWriter writer = new FileWriter("notes2.csv", false)) {
            String text = ;
            writer.write(text);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
