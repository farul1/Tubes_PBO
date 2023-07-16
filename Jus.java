package cafe_kasir;

import javax.swing.JOptionPane;


public class Jus extends Minuman {
    private String fruit;
    String[] fruits = {"Strawberry", "Apple", "Orange"};

    public Jus(String size, int amount, Cafe_kasir lbl) {
        super(size, amount);
        try {
            fruit = (String) JOptionPane.showInputDialog(lbl, "Select a fruit.", "Select a fruit",
                    JOptionPane.QUESTION_MESSAGE, null, fruits, fruits[0]);

            double price;
            price = switch (size) {
                case "Small" -> 4000;
                case "Medium" -> 5000;
                default -> 6000;
            };
            if (fruit.equalsIgnoreCase("Strawberry")) price += 5000;
            if (fruit.equalsIgnoreCase("Apple")) price += 6000;
            if (fruit.equalsIgnoreCase("Orange")) price += 4000;
            setPrice(price);
        } catch (NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString() + fruit + " juice ";
    }
}


