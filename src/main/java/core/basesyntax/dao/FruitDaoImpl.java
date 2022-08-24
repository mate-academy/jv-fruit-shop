package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<String> getRecords(String inputFileName) {
        try (BufferedReader transactionReader = new BufferedReader(new FileReader(inputFileName))) {
            List<String> records = new ArrayList<>();
            String currentLine = transactionReader.readLine();
            while (currentLine != null) {
                records.add(currentLine);
                currentLine = transactionReader.readLine();
            }
            return records;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + inputFileName + " not fount", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + inputFileName, e);
        }
    }

    @Override
    public void writeReport(String targetFileName, List<String> report) {
        try {
            File reportFile = new File(targetFileName);
            reportFile.createNewFile();
            BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile));
            for (String reportLine : report) {
                reportWriter.write(reportLine);
                reportWriter.flush();
            }
            reportWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + targetFileName, e);
        }
    }
}
