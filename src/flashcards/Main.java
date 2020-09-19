package flashcards;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Map<String,String> cards = new LinkedHashMap<>();
        //get how many cards to be created
        System.out.println("Input the number of cards:");
        int numberOfCards = scanner.nextInt();
        scanner.nextLine();
        //get card with corresponding cardterm and definatio
        for(int i=1;i<=numberOfCards;i++){
            System.out.println("The card #"+i+":");
             String card=scanner.nextLine();
                 System.out.println("The definition of the card #"+i+":");
             String def=scanner.nextLine();
             //add cardterm,defination pair to map(cards)
             cards.put(card,def);
        }
        //get the ketset from set and copy  to array
       String[] terms = new String[cards.size()];
        cards.keySet().toArray(terms);
        // Random random = new Random();
        // String term = terms[random.nextInt(terms.length)];
        // String correctAnswer=cards.get(term);


        //play the flash card game
        for(int j=0;j<terms.length;j++){
            String term =terms[j];
        String correctAnswer=cards.get(term);
        System.out.println("Print the definition of \""+term+"\":");
        String userAnswer = scanner.nextLine();
        if(correctAnswer.equals(userAnswer)){
            System.out.println("Correct!");
        }else{
            System.out.println("Wrong. The right answer is \""+correctAnswer+"\".");
        }
        }

        
       // String s =String.format("Card:\n%s\nDefinition:\n%s",cars,def);
       // System.out.println(s);
        
    }
}
