package cafe_kasir;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderHistory {
    private static final String ORDER_HISTORY_FILE = "order_history.txt";

    public static void saveOrder(String orderSummary, double totalPayment, double paymentReceived, double change) {
        try (FileWriter writer = new FileWriter(ORDER_HISTORY_FILE, true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);

            String orderData = timestamp + "," + orderSummary + "," + totalPayment + "," + paymentReceived + "," + change + "\n";
            writer.write(orderData);
        } catch (IOException e) {
        }
    }
}

