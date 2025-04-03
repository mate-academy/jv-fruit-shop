package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl fileReaderimpl = new FileReaderImpl();
        List<String> lines = fileReaderimpl.read("reportToRead.csv");
        System.out.println(lines);
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
    }
}
