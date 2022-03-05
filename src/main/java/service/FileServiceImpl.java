package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileServiceImpl implements FileService {
    public static final String FRUIT_QUANTITY = "fruit,quantity";

    @Override
    public void getReport(String fromFileName, String toFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        int balanceBanana = 0;
        int returnBanana = 0;
        int supplyBanana = 0;
        int purchaseBanana = 0;
        int remainedBanana = 0;
        int balanceApple = 0;
        int returnApple = 0;
        int supplyApple = 0;
        int purchaseApple = 0;
        int remainedApple = 0;
        try {
            for (String readAllLine : Files.readAllLines(new File(fromFileName).toPath())) {
                String[] split = readAllLine.split(",");
                int parseInt = Integer.parseInt(split[2]);
                if (readAllLine.contains("banana") && readAllLine.contains("b")) {
                    balanceBanana = parseInt;
                } else if (readAllLine.contains("banana") && readAllLine.contains("r")) {
                    returnBanana += parseInt;
                } else if (readAllLine.contains("banana") && readAllLine.contains("s")) {
                    supplyBanana += parseInt;
                } else if (readAllLine.contains("banana") && readAllLine.contains("p")) {
                    purchaseBanana += parseInt;
                } else if (readAllLine.contains("apple") && readAllLine.contains("b")) {
                    balanceApple = parseInt;
                } else if (readAllLine.contains("apple") && readAllLine.contains("r")) {
                    returnApple += parseInt;
                } else if (readAllLine.contains("apple") && readAllLine.contains("s")) {
                    supplyApple += parseInt;
                } else {
                    purchaseApple += parseInt;
                }
                remainedApple = balanceBanana + returnBanana + supplyBanana - purchaseBanana;
                remainedApple = balanceApple + returnApple + supplyApple - purchaseApple;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fromFileName);
        }
        String result = stringBuilder.append(FRUIT_QUANTITY)
                .append(System.lineSeparator())
                .append("banana")
                .append(",")
                .append(remainedBanana)
                .append(System.lineSeparator())
                .append("apple")
                .append(",")
                .append(remainedApple).toString();
        writeData(toFileName, result);
    }

    public void writeData(String toFileName, String data) {
        try {
            Files.write(Path.of(toFileName), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data into file " + toFileName);
        }
    }
}