class TicketCounter {
    private int availableSeats = 5;

    public synchronized void bookTicket(String customerName, int seatsRequested) {
        if (seatsRequested <= availableSeats) {
            System.out.println(customerName + " booked " + seatsRequested + " seat(s). ✅");
            availableSeats -= seatsRequested;
        } else {
            System.out.println(customerName + " booking failed. ❌ Only " + availableSeats + " seat(s) left.");
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class BookingThread extends Thread {
    private TicketCounter counter;
    private String customerName;
    private int seatsRequested;

    public BookingThread(TicketCounter counter, String customerName, int seatsRequested, int priority) {
        this.counter = counter;
        this.customerName = customerName;
        this.seatsRequested = seatsRequested;
        this.setName(customerName);
        this.setPriority(priority);
    }

    public void run() {
        counter.bookTicket(customerName, seatsRequested);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Create booking threads (VIPs get higher priority)
        BookingThread t1 = new BookingThread(counter, "Alice (VIP)", 2, Thread.MAX_PRIORITY);
        BookingThread t2 = new BookingThread(counter, "Bob", 2, Thread.NORM_PRIORITY);
        BookingThread t3 = new BookingThread(counter, "Charlie", 1, Thread.NORM_PRIORITY);
        BookingThread t4 = new BookingThread(counter, "Dave (VIP)", 2, Thread.MAX_PRIORITY);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
