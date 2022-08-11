package service;

import dao.ProductDao;
import dao.ProductDaoImpl;
import db.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService{
    private static final String INITIAL_FORMAT = "name,quantity\n";
    private static final String FORMAT = "%s,%s\n";
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public void writeToFile(String toFile) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(toFile, true));
            bufferedWriter.write(INITIAL_FORMAT);
            BufferedWriter finalBufferedWriter = bufferedWriter;
            productDao.getAll().forEach(i -> {
                try {
                    finalBufferedWriter.write(String.format(FORMAT, i.getProductName(), i.getProductCount()));
                } catch (IOException e) {
                    throw new RuntimeException("Can't write data to file", e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't write data to file", e);
                }
            }
        }
    }
}
