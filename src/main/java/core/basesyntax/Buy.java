package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.BuyInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Buy implements BuyInterface<String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    @Override
    public List<String> buying(List<String> fruitsAvailable, String fruitsFromFile)
            throws Exception {
        int c = 1;
        int count = 0;
        for (int j = 0; j < fruitsAvailable.size(); j++) {
            int amountBuyng = Integer.parseInt(fruitsFromFile.split(",")[2]);
            if (fruitsFromFile.split(",")[1]
                    .equals(fruitsAvailable.get(j).split(",")[1])) {
                LocalDate dateSupply = LocalDate.parse(fruitsAvailable.get(j)
                        .split(",")[3], FORMATTER);
                LocalDate dateBuy = LocalDate.parse(fruitsFromFile
                        .split(",")[3], FORMATTER);
                if (dateBuy.isEqual(dateSupply)
                        || dateBuy.isBefore(dateSupply)) {
                    count++;
                    if (Integer.parseInt(fruitsAvailable.get(j).split(",")[2]) >= amountBuyng) {
                        int k = Integer.parseInt(fruitsAvailable.get(j)
                                .split(",")[2]) - amountBuyng;
                        String newAmounrOfFruits = "" + k;
                        String[] splitAvailable = fruitsAvailable.get(j).split(",");
                        splitAvailable[2] = newAmounrOfFruits;
                        String newString = "";
                        for (String s : splitAvailable) {
                            newString = newString + s + ",";
                        }
                        fruitsAvailable.set(j, newString.substring(0, newString.length() - 1));
                        c = 0;
                        break;
                    } else {
                        if (amountBuyng > Integer.parseInt(fruitsAvailable.get(j).split(",")[2])) {
                            String newAmounrOfFruits = "0";
                            String[] splitAvailable = fruitsAvailable.get(j).split(",");
                            splitAvailable[2] = newAmounrOfFruits;
                            String newString = "";
                            for (String s : splitAvailable) {
                                newString = newString + s + ",";
                            }
                            fruitsAvailable.set(j, newString.substring(0, newString.length() - 1));
                        }
                    }
                }
            }
        }
        if (c == 1 && count != 0) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        return fruitsAvailable;
    }
}
