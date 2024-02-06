package Controler;
import java.util.ArrayList;
import java.util.Random;

import Model.Toys;

public class ToyLotto {
    ArrayList<Toys> toys;
    public static Random random = new Random();

    public ToyLotto() {
        toys = new ArrayList<>();
    }

    public void put (Toys toy) {
        toys.add(toy);
    }

    public String getToysQty() {
        StringBuilder toysQty = new StringBuilder("\nОстаток:\n");
        for (Toys toy : toys) {
            toysQty.append(String.format("%s: %s\n",
                    toy.name,
                    toy.qty));
        }
        toysQty.append("\n");
        return toysQty.toString();
    }

    private Toys randomToy() {
        ArrayList<Integer> lottoDrum = new ArrayList();
        for (Toys toy : toys) {
            for (int i = 0; i < toy.qty; i++) lottoDrum.add(toy.id);
        }
        try {
            int randomId = lottoDrum.get(random.nextInt(lottoDrum.size()));
            for (Toys toy : toys) {
                if (toy.id == randomId) {
                    return toy;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Toys get() {
       Toys toy = randomToy();
       if (toy != null) {
           toy.qty -= 1;
       }
       return toy;
    }
}
