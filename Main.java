import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Controler.ToyLotto;
import Model.Toys;


public class Main {
    static String FILE_PATH = "results.txt";
    private static void saveToFile(String text) {
        File file = new File(FILE_PATH);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ToyLotto lotto = new ToyLotto();
        lotto.put(new Toys(1, "Lego", 10));
        lotto.put(new Toys(2, "Robot", 10));
        lotto.put(new Toys(3, "Barbie", 10));
        lotto.put(new Toys(4, "Car", 10));
        lotto.put(new Toys(5, "Puppet", 10));

        for (int attempt = 1; attempt <= 10; attempt++) {
            Toys toy = lotto.get();
            if (toy != null) {
                String str = String.format("Попытка %d: %s\n", attempt, toy);
                System.out.printf(str);
                saveToFile(str);
            } else {
                String str = String.format("Попытка %d: Игрушки закончились\n", attempt);
                System.out.printf(str);
                saveToFile(str);
                break;
            }
        }
        String str = lotto.getToysQty();
        System.out.println(str);
        saveToFile(str);
    }
}