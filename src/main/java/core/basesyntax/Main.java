package core.basesyntax;

import core.basesyntax.read.ReadFile;
import core.basesyntax.write.WriteToFile;

public class Main {
        public static void main(String[] args) {
            ReadFile fileService = new ReadFile();
            fileService.readFile("src/test/resources/test_1.csv");
            WriteToFile recordingService = new WriteToFile();
            recordingService.writingToFile();
        }
    }
