package core.basesyntax;

import core.basesyntax.service.ReadDataFromFile;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadDataFromFileImpl implements ReadDataFromFile {

    @Override
    public String readDataFromFile(String fromFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(fromFileName))) {
            String value = bufferReader.readLine();
            while (value != null) {
                stringBuilder.append(value)
                        .append("\n");
                value = bufferReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("File can not be read");
        }
        String s = stringBuilder.toString();
        System.out.println(s);
        return s;
    }
}
