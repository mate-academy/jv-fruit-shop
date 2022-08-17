package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Product;

public class WriterServiceImpl implements WriterService {
    private static final String INITIAL_FORMAT = "name,quantity\n";
    private static final String FORMAT = "%s,%s\n";

    @Override
    public void writeToFile(String toFile, List<Product> products) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(toFile));
            bufferedWriter.write(INITIAL_FORMAT);
            BufferedWriter finalBufferedWriter = bufferedWriter;
            products.forEach(i -> {
                try {
                    finalBufferedWriter.write(String.format(FORMAT, i.getName(), i.getCount()));
                } catch (IOException e) {
                    throw new RuntimeException("Can't write data to file " + toFile, e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFile, e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't write data to file " + toFile, e);
                }
            }
        }
    }
}
