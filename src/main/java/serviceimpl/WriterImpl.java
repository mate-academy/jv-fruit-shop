package serviceimpl;

import service.WriterService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements WriterService {

    @Override
    public void write(File outputFileName, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            if (report != null) {
                bufferedWriter.write(report);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + outputFileName + " not found!", e);
        } catch (IOException e) {
            throw new RuntimeException("File " + outputFileName + " can't be wrote!", e);
        }
    }
}
