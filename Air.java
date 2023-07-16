package cafe_kasir;

import javax.swing.JOptionPane;

public class Air extends Minuman {
    private final boolean iced;

    public Air(String size, int amount, Cafe_kasir lbl) {
        super(size, amount);
        iced = JOptionPane.showConfirmDialog(lbl, "Would you like ice?", "Ice", JOptionPane.YES_NO_OPTION) == 0;

        double price;
        price = switch (size) {
            case "Small" -> 3000;
            case "Medium" -> 4000;
            default -> 5000;
        };
        if (iced) price *= 2.0;
        setPrice(price);
    }

    @Override
    public String toString() {
        if (iced) return super.toString() + "Water with ice";
        else return super.toString() + " Water";
    }
}




