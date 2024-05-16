package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.OperationStrategy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    private static final String INPUT_FILE = "input.csv";
    private static final String SEPARATOR = ",";
    private static final String REPORT_FILE = "report.csv";
    private FruitTransactionServiceImpl fruitTransactionService;

    public FileServiceImpl(FruitDao fruitDao, OperationStrategy strategy) {
        fruitTransactionService = new FruitTransactionServiceImpl(fruitDao, strategy);
    }

    @Override
    public void writeReport() {
        try (FileOutputStream outputStream = new FileOutputStream(REPORT_FILE)) {
            String title = "fruit,quantity";
            StringBuilder reportBuilder = new StringBuilder(title).append(System.lineSeparator());

            for (String fruit : Storage.fruitNames) {
                reportBuilder
                        .append(fruit)
                        .append(SEPARATOR)
                        .append(fruitTransactionService.getFruitCount(fruit))
                        .append(System.lineSeparator());
            }
            byte[] bytes = reportBuilder.toString().getBytes();

            outputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readInput() {
        try (InputStream inputStream = FruitTransactionServiceImpl.class
                .getClassLoader().getResourceAsStream(INPUT_FILE);
                Scanner scanner = new Scanner(inputStream)) {

            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + inputStream);
            }

            // Skip the title line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(SEPARATOR);
                fruitTransactionService.createNewFruitTransaction(
                        row[0],
                        row[1],
                        Integer.parseInt(row[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
