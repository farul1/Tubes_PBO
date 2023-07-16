package cafe_kasir;

import javax.swing.JOptionPane;

public class Kopi extends Minuman {
    private boolean milk;

    public Kopi(String size, int amount, Cafe_kasir lbl) {
        super(size, amount);
        milk = JOptionPane.showConfirmDialog(lbl, "Would you like milk?", "Milk", JOptionPane.YES_NO_OPTION) == 0;

        double basePrice;
        double milkPrice = 0.0;
        basePrice = switch (size) {
            case "Small" -> 10000;
            case "Medium" -> 11000;
            default -> 12000;
        };
        if (milk) {
            milkPrice = 2000;
        }
        setPrice(basePrice + milkPrice);
    }

    @Override
    public String toString() {
        if (milk) {
            return super.toString() + "Coffee with milk";
        } else {
            return super.toString() + "Coffee";
        }
    }
}


