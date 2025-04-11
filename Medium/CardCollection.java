import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public void display() {
        System.out.println("Card: " + value + " of " + symbol);
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Card>> cardMap = new HashMap<>();

        System.out.print("Enter number of cards to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Add cards
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter card " + i + " details:");
            System.out.print("Symbol: ");
            String symbol = scanner.nextLine();
            System.out.print("Value: ");
            String value = scanner.nextLine();

            Card card = new Card(symbol, value);
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(card);
        }

        // Search cards
        System.out.print("\nEnter a symbol to search cards: ");
        String searchSymbol = scanner.nextLine();

        if (cardMap.containsKey(searchSymbol)) {
            System.out.println("\nCards with symbol \"" + searchSymbol + "\":");
            for (Card card : cardMap.get(searchSymbol)) {
                card.display();
            }
        } else {
            System.out.println("❌ No cards found with symbol \"" + searchSymbol + "\".");
        }

        scanner.close();
    }
}
