package core.basesyntax.orderprocessing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.customexceptions.BadFileFormatting;
import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileReader {
    private static final String[] HEADER = new String[]{"type", "fruit", "quantity", "date"};

    public List<Order> formOrders(String path) {
        List<Order> orders = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] line;
            if (isNotHeader(csvReader.readNext())) {
                throw new BadFileFormatting("File with wrong header!!");
            }
            while ((line = csvReader.readNext()) != null) {
                FruitPack fruitPack = new FruitPack(line[1],
                        Integer.parseInt(line[2]),
                        LocalDate.parse(line[3]));
                orders.add(new Order(fruitPack, line[0]));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Order generation failed!!", e);
        }
        return orders;
    }

    private boolean isNotHeader(String[] firstLine) {
        return !(Arrays.equals(firstLine, HEADER));
    }
}
