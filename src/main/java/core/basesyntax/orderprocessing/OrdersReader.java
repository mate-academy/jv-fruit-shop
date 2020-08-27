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
import java.util.List;

public class OrdersReader {
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
            throw new RuntimeException(e.getMessage(), e);
        }
        return orders;
    }

    private boolean isNotHeader(String[] firstLine) {
        return firstLine == null
                || firstLine.length != HEADER.length
                || !(firstLine[0].equals(HEADER[0])
                && firstLine[1].equals(HEADER[1])
                && firstLine[2].equals(HEADER[2])
                && firstLine[3].equals(HEADER[3]));
    }
}
