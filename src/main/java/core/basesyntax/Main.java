package core.basesyntax;

import core.basesyntax.read.FileService;
import core.basesyntax.write.RecordingService;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readFromFile("/Users/artem2/Mate Academy/jv-fruit-shop/src/test/resources/base.csv");
        RecordingService recordingService = new RecordingService();
        recordingService.writingToFile();

    }
}
