package flashcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mappedCards = new LinkedHashMap<>();
        //get how many mappedCards to be created
        System.out.println("Input the number of mappedCards:");
        int numberOfCards = scanner.nextInt();
        scanner.nextLine();
        //add mappedCards with corresponding cardterm and defination
        addCards(scanner, mappedCards, numberOfCards);
        //get the ketset from set and copy  to array
        String[] cardTerms = new String[mappedCards.size()];
        mappedCards.keySet().toArray(cardTerms);

        //play the flash card game
        for (String term : cardTerms) {
            String correctAnswer = mappedCards.get(term);
            System.out.println("Print the definition of \"" + term + "\":");
            String userAnswer = scanner.nextLine();
            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                //getting correct card for the user answer
                final String[] correctCard = new String[1];
                mappedCards.forEach((key, value) -> {
                    if (userAnswer.equals(value.toLowerCase())) {
                        correctCard[0] = key;
                    }
                });
                System.out.println("Wrong. The right answer is \"" + correctAnswer +
                        "\",but your definition is correct for \"" + correctCard[0] + "\"");
            }
        }


        // String s =String.format("Card:\n%s\nDefinition:\n%s",cars,def);
        // System.out.println(s);

    }

    static void addCards(Scanner scanner, Map<String, String> cards, int numberOfCards) {
        for (int i = 1; i <= numberOfCards; i++) {
            System.out.println("The card #" + i + ":");
            String card = scanner.nextLine();
            //avoiding duplicate keys
            while (cards.containsKey(card.toLowerCase())) {
                System.out.println("The card \"" + card + "\" already exists. Try again:");
                card = scanner.nextLine();
            }
            System.out.println("The definition of the card #" + i + ":");
            String def = scanner.nextLine();
            //avoiding duplicate values
            while (cards.containsValue(def.toLowerCase())) {
                System.out.println("The definition \"" + def + "\" already exists. Try again:");
                def = scanner.nextLine();
            }
            //add cardterm,defination pair to map(cards)
            cards.put(card.toLowerCase(), def.toLowerCase());
        }
    }
}
