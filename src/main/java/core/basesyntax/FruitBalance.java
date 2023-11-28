package core.basesyntax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class  FruitBalance {
    private int appleBalance = 0;
    private int bananaBalance = 0;

    public int getAppleBalance() {
        return appleBalance;
    }

    public void setAppleBalance(int appleBalance) {
        this.appleBalance = appleBalance;
    }

    public int getBananaBalance() {
        return bananaBalance;
    }

    public void setBananaBalance(int bananaBalance) {
        this.bananaBalance = bananaBalance;
    }

    public boolean writeBalance() throws IOException { //method for writing a balance to file balance.csv
        File csvFile = new File("src/main/resources/balance.csv");
        FileWriter fileWriter = new FileWriter(csvFile);
        StringBuilder line = new StringBuilder();

        line.append("fruit,quantity" + "\n");
        line.append("apple," + appleBalance + "\n");
        line.append("banana," + bananaBalance);
        line.append("\n");
        fileWriter.write(line.toString());
        fileWriter.close();
        return true;
    }
}
