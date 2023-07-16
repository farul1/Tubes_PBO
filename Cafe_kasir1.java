
package cafe_kasir;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cafe_kasir1 extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblReport, img;
    private JComboBox<String> size;
    private JRadioButton rdJus, rdAir, rdTeh, rdKopi;
    private ButtonGroup btnGroup;
    private JTextField txtGlass;
    private JButton btnAdd, btnOrder, btnCancel, btnLogout;
    int amount_of;
    List<Minuman> list_of_bvr = new ArrayList<>();
    
    public Cafe_kasir1() {
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Order Drinks");
        init();
        btnAdd.addActionListener((ActionListener) this);
        btnOrder.addActionListener((ActionListener) this);
        btnCancel.addActionListener((ActionListener) this);
        btnLogout.addActionListener((ActionListener) this); 
        initBackground();
        setVisible(true);
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBev = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        JComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        lblBev.setText("Select which type of drink you want to order");
        jPanel1.add(lblBev, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 135, -1, -1));

        jRadioButton2.setText("Coffee");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 170, -1, -1));

        jRadioButton3.setText("Juice");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jRadioButton4.setText("Water");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 170, -1, -1));

        jRadioButton5.setText("Tea");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel2.setText("Select Size:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 100, 25));

        jLabel3.setText("How many glasses you want to order:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 245, 500, 50));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 285, 300, 25));

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 120, 40));

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 120, 40));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 500, 50));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 120, 40));

        jButton9.setText("Order");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 120, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe_kasir/menu.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnLogout = new JButton("Logout");
        btnLogout.setSize(120, 40);
        btnLogout.setLocation(280, 390);
        add(btnLogout);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxActionPerformed
        String[] sizes = { "Small", "Medium", "Large" };
        size = new JComboBox<>(sizes);
        size.setSelectedIndex(0);
        size.setSize(100, 25);
        size.setLocation(270, 222);
        add(size);
    }//GEN-LAST:event_JComboBoxActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        rdTeh = new JRadioButton("Tea");
        rdTeh.setSize(75, 50);
        rdTeh.setLocation(250, 170);
        add(rdTeh);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        rdAir = new JRadioButton("Water");
        rdAir.setSize(75, 50);
        rdAir.setLocation(175, 170);
        add(rdAir);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        rdJus = new JRadioButton("Juice");
        rdJus.setSize(75, 50);
        rdJus.setLocation(100, 170);
        add(rdJus);
        
        btnGroup.add(rdJus);
        btnGroup.add(rdAir);
        btnGroup.add(rdTeh);
        btnGroup.add(rdKopi);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        rdKopi = new JRadioButton("Coffee");
        rdKopi.setSize(75, 50);
        rdKopi.setLocation(325, 170);
        add(rdKopi);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        btnCancel = new JButton("Cancel");
        btnCancel.setSize(120, 40);
        btnCancel.setLocation(100, 390);
        btnCancel.setEnabled(false);
        add(btnCancel);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        btnOrder = new JButton("Order");
        btnOrder.setSize(120, 40);
        btnOrder.setLocation(280, 330);
        btnOrder.setEnabled(false);
        add(btnOrder);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        txtGlass = new JTextField();
        txtGlass.setSize(300, 25);
        txtGlass.setLocation(100, 285);
        add(txtGlass);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        btnAdd = new JButton("Add");
        btnAdd.setSize(120, 40);
        btnAdd.setLocation(100, 330);
        add(btnAdd);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void initBackground() {
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/menu.png")));
        background.setBounds(0, 0, 800, 600);
        add(background);
    }
    
    public void actionPerformed(ActionEvent e) {
        String size_of = (String) size.getSelectedItem();

        if (e.getSource().equals(btnAdd)) {
            if ((rdJus.isSelected() || rdTeh.isSelected() || rdKopi.isSelected() || rdAir.isSelected())
                    && !(txtGlass.getText().isEmpty())) {
                try {
                    amount_of = Integer.parseInt(txtGlass.getText().trim());
                    if (amount_of <= 0) {
                        JOptionPane.showMessageDialog(this, "Number of drinks must be greater than 0.");
                        return;
                    }
                   Cafe_kasir1.Minuman bvg;
                    ImageIcon drinkIcon;
                    if (rdJus.isSelected()) {
                        bvg = new Jus(size_of, amount_of, this);
                        drinkIcon = new ImageIcon(getClass().getResource("/img/jus.png"));
                    } else if (rdAir.isSelected()) {
                        bvg = new Air(size_of, amount_of, this);
                        drinkIcon = new ImageIcon(getClass().getResource("/img/air.png"));
                    } else if (rdTeh.isSelected()) {
                        bvg = new Teh(size_of, amount_of, this);
                        drinkIcon = new ImageIcon(getClass().getResource("/img/teh.png"));
                    } else {
                        bvg = new Kopi(size_of, amount_of, this);
                        drinkIcon = new ImageIcon(getClass().getResource("/img/kopi.png"));
                    }
                    img.setIcon(drinkIcon);

                    txtGlass.setText(null);
                    list_of_bvr.add(bvg);
                    lblReport.setText(bvg.toString() + " added");
                    btnGroup.clearSelection();
                    btnOrder.setEnabled(true);
                    btnCancel.setEnabled(true);
                    btnLogout.setEnabled(true);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Enter an integer as amount");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Choose a beverage type and enter an amount");
            }
        } else if (e.getSource().equals(btnOrder)) {
            if (list_of_bvr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No items added. Please add items to place an order.");
                return;
            }
            String report = "";
            double pay = calculateTotalPayment();
            DecimalFormat decimalFormat = new DecimalFormat("###.000");
            for (int i = 0; i < list_of_bvr.size(); i++) {
                Minuman bvgi = list_of_bvr.get(i);
                report += bvgi.toString();
                double totalprice_of_bvg = bvgi.getAmount() * bvgi.getPrice();
                report = report + " - " + decimalFormat.format(totalprice_of_bvg) + " Rupiah\n";
            }
            JOptionPane.showMessageDialog(this, report);
            String paymentString = JOptionPane.showInputDialog(this, "Enter the payment amount in IDR:");
            if (paymentString != null && !paymentString.isEmpty()) {
                try {
                    double payment = Double.parseDouble(paymentString);
                    double change = payment - pay;
                    JOptionPane.showMessageDialog(this, "Total payment: " + decimalFormat.format(pay)
                            + " Rupiah\nPayment received: " + decimalFormat.format(payment)
                            + " Rupiah\nChange: " + decimalFormat.format(change) + " Rupiah");
                    resetOrder();
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Invalid payment amount");
                }
            }
        } else if (e.getSource().equals(btnCancel)) {
            resetOrder();
        } else if (e.getSource().equals(btnLogout)) {
            dispose();
            KaryawanLogin1 login = new KaryawanLogin1();
            login.setVisible(true);
        }
    }
   public static void main(String[] args) {
        new Cafe_kasir().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> JComboBox;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBev;
    // End of variables declaration//GEN-END:variables

    private double calculateTotalPayment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void resetOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void init() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private abstract class Minuman {
	private String size;
	private double price;
	private int amount;
	
	public Minuman(String size,int amount) {
		super();
		this.size = size;
		this.amount = amount;
		price = 0.0;	
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s glass(es) of",this.getAmount(),this.getSize());
	}
}
    class Jus extends Cafe_kasir1.Minuman {
	private String fruit;
	String[] fruits = {"Strawberry","Apple","Orange"};

	public Jus(String size,int amount,Cafe_kasir1 lbl) {
		super(size,amount);
		try {
			fruit = (String) JOptionPane.showInputDialog(lbl,"Select a fruit.","Select a fruit",
					JOptionPane.QUESTION_MESSAGE,null,fruits,fruits[0]);
			
			double price;
                        price = switch (size) {
                        case "Small" -> 4.000;
                        case "Medium" -> 5.000;
                        default -> 6.000;
                    };
			if(fruit.equals("Strawberry")) price*=3.000;
			if(fruit.equals("Apple")) price*=4.000;
                        if(fruit.equals("Orange")) price*=3.000;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+fruit+" juice";
	}
}
    class Kopi extends Cafe_kasir1.Minuman {
	private final boolean milk; 

	public Kopi(String size,int amount,Cafe_kasir1 lbl) {
		super(size,amount);
                milk = JOptionPane.showConfirmDialog(lbl, " Would you like milk?","Milk",JOptionPane.YES_NO_OPTION)==0;
		double price;
                price = switch (size) {
                case "Small" -> 10.000;
                case "Medium" -> 11.000;
                default -> 12.000;
            };
		if(milk) price*=2.000;
		setPrice(price);
	}

	@Override
	public String toString() {
		if(milk) return super.toString()+" Coffee with milk";
		else return super.toString()+" Coffee";
	}

}
    class Air extends Cafe_kasir1.Minuman {
	private final boolean iced;

	public Air (String size,int amount,Cafe_kasir1 lbl) {
		super(size,amount);
                iced = JOptionPane.showConfirmDialog(lbl, " Would you like ice?"," Ice",JOptionPane.YES_NO_OPTION)==0;
		double price;
                price = switch (size) {
                case "Small" -> 3.000;
                case "Medium" -> 4.000;
                default -> 5.000;
            };
		if(iced) price*=2.000; 
		setPrice(price);

	}

	@Override
	public String toString() {
		if(iced) return super.toString()+" Water with ice";
		else return super.toString()+" Water";
	}
}
    class Teh extends Cafe_kasir1.Minuman {
	private String fruit;
	String[] fruits = {"Lemon","Lychee"};

	public Teh(String size,int amount,Cafe_kasir1 lbl) {
		super(size,amount);
		try {
			fruit = (String) JOptionPane.showInputDialog(lbl,"Select a fruit.","Select a fruit",
					JOptionPane.QUESTION_MESSAGE,null,fruits,fruits[0]);
			
			double price;
                        price = switch (size) {
                        case "Small" -> 4.000;
                        case "Medium" -> 5.000;
                        default -> 6.000;
                    };
			if(fruit.equals("Lemon")) price*=3.000;
			if(fruit.equals("Lychee")) price*=3.000;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+fruit+" Tea";
	}
    }
}
