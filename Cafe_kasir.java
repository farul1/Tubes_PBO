package cafe_kasir;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public final class Cafe_kasir extends JFrame implements Orderable {

    private static final long serialVersionUID = 1L;
    private JLabel lblBev, lblSize, lblGlass, lblReport, img;
    private JComboBox<String> size;
    private JRadioButton rdJuice, rdWater, rdTea, rdCoffee;
    private ButtonGroup btnGroup;
    private JTextField txtGlass;
    private JButton btnAdd, btnOrder, btnCancel, btnLogout, btnHistory, btnReset;
    private DefaultTableModel historyTableModel;
    private List<String> orderHistoryList;
    private static final String ORDER_HISTORY_FILE = "order_history.txt";
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    int amount_of;
    List<Minuman> beverageList = new ArrayList<>();

    public Cafe_kasir() {
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Order Drinks");
        init();
        btnAdd.addActionListener(e -> handleAddButtonClicked());
        btnOrder.addActionListener(e -> handleOrderButtonClicked());
        btnCancel.addActionListener(e -> handleCancelButtonClicked());
        btnLogout.addActionListener(e -> handleLogoutButtonClicked());
        btnHistory.addActionListener(e -> handleHistoryButtonClicked());
        initBackground();
        setVisible(true);
    }

    public void init() {
        lblBev = new JLabel("Select the type of beverage you want to order");
        lblBev.setSize(500, 50);
        lblBev.setLocation(100, 135);
        add(lblBev);

        btnGroup = new ButtonGroup();

        rdJuice = new JRadioButton("Juice");
        rdJuice.setSize(75, 50);
        rdJuice.setLocation(100, 170);
        add(rdJuice);

        rdWater = new JRadioButton("Water");
        rdWater.setSize(75, 50);
        rdWater.setLocation(175, 170);
        add(rdWater);

        rdTea = new JRadioButton("Tea");
        rdTea.setSize(75, 50);
        rdTea.setLocation(250, 170);
        add(rdTea);

        rdCoffee = new JRadioButton("Coffee");
        rdCoffee.setSize(75, 50);
        rdCoffee.setLocation(325, 170);
        add(rdCoffee);

        btnGroup.add(rdJuice);
        btnGroup.add(rdWater);
        btnGroup.add(rdTea);
        btnGroup.add(rdCoffee);

        rdJuice.setOpaque(false);
        rdWater.setOpaque(false);
        rdTea.setOpaque(false);
        rdCoffee.setOpaque(false);

        lblSize = new JLabel("Select Size:");
        lblSize.setSize(150, 50);
        lblSize.setLocation(100, 210);
        add(lblSize);

        String[] sizes = { "Small", "Medium", "Large" };
        size = new JComboBox<>(sizes);
        size.setSelectedIndex(0);
        size.setSize(100, 25);
        size.setLocation(270, 222);
        add(size);

        lblGlass = new JLabel("How many glasses do you want to order:");
        lblGlass.setSize(500, 50);
        lblGlass.setLocation(100, 245);
        add(lblGlass);

        txtGlass = new JTextField();
        txtGlass.setSize(300, 25);
        txtGlass.setLocation(100, 285);
        add(txtGlass);

        btnAdd = new JButton();
        btnAdd.setSize(40, 40);
        btnAdd.setLocation(400, 275);
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/img/add.png")));
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setBorderPainted(false);
        add(btnAdd);

        btnOrder = new JButton("Order");
        btnOrder.setSize(120, 40);
        btnOrder.setLocation(280, 330);
        btnOrder.setIcon(new ImageIcon(getClass().getResource("/img/Order.png")));
        btnOrder.setEnabled(false);
        add(btnOrder);

        btnCancel = new JButton("Cancel");
        btnCancel.setSize(120, 40);
        btnCancel.setLocation(100, 330);
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/Cancel.png")));
        btnCancel.setEnabled(false);
        add(btnCancel);

        btnLogout = new JButton("Logout");
        btnLogout.setSize(120, 40);
        btnLogout.setLocation(640, 500);
        //btnLogout.setLocation(20, 500);
        btnLogout.setIcon(new ImageIcon(getClass().getResource("/img/Keluar.png")));
        add(btnLogout);


        btnHistory = new JButton("History");
        btnHistory.setSize(120, 40);
        btnHistory.setLocation(20, 500);
        //btnHistory.setLocation(640, 500);
        btnHistory.setIcon(new ImageIcon(getClass().getResource("/img/histori.png")));
        add(btnHistory);

        lblReport = new JLabel();
        lblReport.setSize(500, 50);
        lblReport.setLocation(100, 420);
        add(lblReport);

        img = new JLabel();
        img.setBounds(500, 180, 250, 250);
        add(img);

        orderHistoryList = new ArrayList<>();
        historyTableModel = new DefaultTableModel();
        historyTableModel.addColumn("Order");
        historyTableModel.addColumn("Total Payment");
    }

    private void initBackground() {
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/bgmenu.png")));
        background.setBounds(0, 0, 800, 600);
        add(background);
    }

    private void handleAddButtonClicked() {
        if ((rdJuice.isSelected() || rdTea.isSelected() || rdCoffee.isSelected() || rdWater.isSelected())
                && !(txtGlass.getText().isEmpty())) {
            try {
                amount_of = Integer.parseInt(txtGlass.getText().trim());
                if (amount_of <= 0) {
                    JOptionPane.showMessageDialog(this, "The amount of beverage must be greater than 0.");
                    return;
                }
                Minuman beverage;
                ImageIcon drinkIcon;
                if (rdJuice.isSelected()) {
                    try {
                        beverage = new Jus(size.getSelectedItem().toString(), amount_of, this);
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(this, "Order cancelled.");
                        return;
                    }
                    drinkIcon = new ImageIcon(getClass().getResource("/img/jus.png"));
                } else if (rdWater.isSelected()) {
                    beverage = new Air(size.getSelectedItem().toString(), amount_of, this);
                    drinkIcon = new ImageIcon(getClass().getResource("/img/air.png"));
                } else if (rdTea.isSelected()) {
                    try {
                        beverage = new Teh(size.getSelectedItem().toString(), amount_of, this);
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(this, "Order cancelled.");
                        return;
                    }
                    drinkIcon = new ImageIcon(getClass().getResource("/img/teh.png"));
                } else {
                    beverage = new Kopi(size.getSelectedItem().toString(), amount_of, this);
                    drinkIcon = new ImageIcon(getClass().getResource("/img/kopi.png"));
                }

                img.setIcon(drinkIcon);

                txtGlass.setText(null);
                beverageList.add(beverage);
                lblReport.setText(beverage.toString() + " added");
                btnGroup.clearSelection();
                btnOrder.setEnabled(true);
                btnCancel.setEnabled(true);
                btnLogout.setEnabled(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter an integer as the amount");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select the type of beverage and enter the amount");
        }
    }


    private void handleOrderButtonClicked() {
        if (beverageList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items added. Please add items to place an order.");
            return;
        }
        String report = "";
        double pay = calculateTotalPayment();
        for (int i = 0; i < beverageList.size(); i++) {
            Minuman beverage = beverageList.get(i);
            report += beverage.toString();
            double totalprice_of_beverage = beverage.getAmount() * beverage.getPrice();
            report = report + " - " + decimalFormat.format(totalprice_of_beverage) + " Rupiah\n";
        }

        JOptionPane.showMessageDialog(this, report);
        String paymentString = JOptionPane.showInputDialog(this, "Enter the payment amount in Rupiah:");
        if (paymentString != null && !paymentString.isEmpty()) {
            try {
                double payment = Double.parseDouble(paymentString);
                double change = payment - pay;
                JOptionPane.showMessageDialog(this, "Total Payment: " + decimalFormat.format(pay)
                        + " Rupiah\nPayment Received: " + decimalFormat.format(payment)
                        + " Rupiah\nChange: " + decimalFormat.format(change) + " Rupiah");
                saveOrderHistory(report, decimalFormat.format(pay), decimalFormat.format(payment), decimalFormat.format(change));
                printOrder(report, decimalFormat.format(pay), decimalFormat.format(payment), decimalFormat.format(change));
                resetOrder();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid payment amount");
            }
        }
    }

    private void handleCancelButtonClicked() {
        resetOrder();
    }

    private void handleLogoutButtonClicked() {
        dispose();
        KaryawanLogin login = new KaryawanLogin();
        login.setVisible(true);
    }

    private void handleHistoryButtonClicked() {
        loadOrderHistory();
        showOrderHistory();
    }

    @Override
    public double calculateTotalPayment() {
        double totalPayment = 0;
        for (Minuman beverage : beverageList) {
            totalPayment += beverage.getAmount() * beverage.getPrice();
        }
        return totalPayment;
    }

    @Override
    public void resetOrder() {
        beverageList.clear();
        lblReport.setText("");
        img.setIcon(null);
        btnOrder.setEnabled(false);
    }

    public void printOrder(String orderSummary, String totalPayment, String paymentReceived, String change) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body>");
        sb.append("<h2>FIFA Drinks Shop</h2>");
        sb.append("<ul>");

        String[] orderLines = orderSummary.split("\n");
        for (String orderLine : orderLines) {
            sb.append("<li>").append(orderLine).append("</li>");
        }

        sb.append("</ul>");
        sb.append("<p>Total Payment: ").append(totalPayment).append(" Rupiah</p>");
        sb.append("<p>Payment Received: ").append(paymentReceived).append(" Rupiah</p>");
        sb.append("<p>Change: ").append(change).append(" Rupiah</p>");
        sb.append("</body></html>");

        String report = sb.toString();

        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                Font titleFont = new Font("Arial", Font.BOLD, 16);
                Font listItemFont = new Font("Arial", Font.PLAIN, 12);
                Font lineFont = new Font("Arial", Font.PLAIN, 10);

                int y = 50;

                g2d.setFont(titleFont);
                g2d.drawString("FIFA Drinks Shop", 50, y);
                y += 30;

                g2d.setFont(listItemFont);
                String[] lines = orderSummary.split("\n");
                for (String line : lines) {
                    g2d.drawString(line, 50, y);
                    y += 20;
                }

                g2d.setFont(lineFont);
                g2d.drawString("-------------------------------------------------------------------------------------------", 50, y);
                y += 20;

                g2d.setFont(listItemFont);
                g2d.drawString("Total Payment:", 50, y);
                g2d.drawString(totalPayment, 200, y);
                y += 20;

                g2d.drawString("Payment Received:", 50, y);
                g2d.drawString(paymentReceived, 200, y);
                y += 20;

                g2d.setFont(lineFont);
                g2d.drawString("-------------------------------------------------------------------------------------------", 50, y);
                y += 20;

                g2d.drawString("Change:", 50, y);
                g2d.drawString(change, 200, y);

                return PAGE_EXISTS;
            });

            boolean printDialogShown = job.printDialog();
            if (printDialogShown) {
                job.print();
            }

            JOptionPane.showMessageDialog(null, report, "", JOptionPane.INFORMATION_MESSAGE);

        } catch (PrinterException ex) {
        }
    }

    private void loadOrderHistory() {
        orderHistoryList.clear();
        try {
            if (!Files.exists(Path.of(ORDER_HISTORY_FILE))) {
                Files.createFile(Path.of(ORDER_HISTORY_FILE));
            }
            orderHistoryList = Files.readAllLines(Path.of(ORDER_HISTORY_FILE));
        } catch (IOException e) {
        }
    }

    private void showOrderHistory() {
        historyTableModel.setRowCount(0);

        for (String orderHistory : orderHistoryList) {
            String[] historyData = orderHistory.split(",");
            historyTableModel.addRow(historyData);
        }

        JTable historyTable = new JTable(historyTableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);

                if (row < getRowCount() - 1) {
                    Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, getGridColor());
                    ((JComponent) component).setBorder(border);
                }

                return component;
            }
        };

        JScrollPane scrollPane = new JScrollPane(historyTable);
        scrollPane.setSize(500, 300);
        scrollPane.setLocation(20, 470);

        historyTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        historyTable.getColumnModel().getColumn(1).setPreferredWidth(100);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setSize(120, 40);
        btnDelete.setLocation(320, 450);
        btnDelete.addActionListener(e -> handleDeleteButtonClicked(historyTable));

        JOptionPane.showMessageDialog(this, new Object[] { scrollPane, btnDelete }, "Order History", JOptionPane.PLAIN_MESSAGE);
    }

    private void handleDeleteButtonClicked(JTable historyTable) {
    int[] selectedRows = historyTable.getSelectedRows();
    if (selectedRows.length > 0) {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected order(s)?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int actualRow = historyTable.convertRowIndexToModel(selectedRows[i]);
                historyTableModel.removeRow(actualRow);
                orderHistoryList.remove(actualRow);
            }
            saveOrderHistoryToFile();
            JOptionPane.showMessageDialog(this, "Selected order(s) have been deleted from the history.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Select the order(s) you want to delete.");
    }
}


    private void saveOrderHistoryToFile() {
        try {
            try (FileWriter writer = new FileWriter(ORDER_HISTORY_FILE)) {
                for (String orderData : orderHistoryList) {
                    writer.write(orderData + "\n");
                }
            }
        } catch (IOException e) {
        }
    }

    private void saveOrderHistory(String orderSummary, String totalPayment, String paymentReceived, String change) {
        String orderData = orderSummary + "," + totalPayment + "," + paymentReceived + "," + change;
        orderHistoryList.add(orderData);
        saveOrderHistoryToFile();
    }

    public static void main(String[] args) {
        new Cafe_kasir().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void order() {
        btnOrder.doClick();
    }

    public void cancel() {
        btnCancel.doClick();
    }
}
