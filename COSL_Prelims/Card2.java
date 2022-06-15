
import java.util.*;
public class Card2 { 
	private int rank; 
	private int suit;

    public final static int DIAMONDS = 1; 
    public final static int CLUBS = 2; 
    public final static int HEARTS = 3; 
    public final static int SPADES = 4;
    
    public final static int ACE = 1; 
    public final static int DEUCE = 2; 
    public final static int THREE = 3; 
    public final static int FOUR = 4; 
    public final static int FIVE = 5; 
    public final static int SIX = 6; 
    public final static int SEVEN = 7; 
    public final static int EIGHT = 8; 
    public final static int NINE = 9; 
    public final static int TEN = 10; 
    public final static int JACK = 11; 
    public final static int QUEEN = 12; 
    public final static int KING = 13;
    
    public Card2(int rank, int suit) { 
        this.rank = rank;
        this.suit = suit;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public int getRank() { 
        return rank;
    }
    
    public static boolean isValidRank(int rank) { 
        return ACE <= rank && rank <= KING;
    }
    
    public static boolean isValidSuit(int suit) { 
        return DIAMONDS <= suit && suit <= SPADES;
    }
    
    public boolean equals(Object obj) { 
        if (obj instanceof Card2) {
            if (((Card2)obj).getRank() == this.rank && ((Card2)obj).getSuit() == this.suit) { 
                return true;
        } else {
            return false;
        }
            } else {
                return false;
        }
    }
    
    public int hashCode() {
    return ((suit-1)*13)+rank;
    }
    
    public String toString() {
        return rankToString(this.rank) + " of "+ suitToString(this.suit);
    }
    
    public static String rankToString(int rank) { 
    switch (rank) {
    case ACE:
        return "Ace"; 
    case DEUCE:
        return "Deuce"; 
    case THREE:
        return "Three";
    case FOUR:
        return "Four"; 
    case FIVE:
        return "Five"; 
    case SIX:
        return "Six"; 
    case SEVEN:
        return "Seven"; 
    case EIGHT:
        return "Eight"; 
    case NINE:
        return "Nine"; 
    case TEN:
        return "Ten"; 
    case JACK:
        return "Jack"; 
    case QUEEN:
        return "Queen"; 
    case KING:
        return "King"; 
    default:
    //Handle an illegal argument. There are generally two ways
    //to handle invalid arguments, throwing an exception (see
    //the section on Handling Exceptions):
    throw new IllegalArgumentException("Invalid rank " + rank);
    //or
    //return null;
    }
    }
    
    public static String suitToString(int suit) { 
        String result = "";
    switch (suit) { 
    case DIAMONDS:
        return "Diamonds"; 
    case CLUBS:
        return "Clubs"; 
    case HEARTS:
        return "Hearts"; 
    case SPADES:
        return "Spades"; 
    default:
    throw new IllegalArgumentException("Invalid suit " + suit);
    }
    }
    
    public static void main(String[] args) { 
        new Card2(ACE, DIAMONDS);
        new Card2(KING, SPADES);
    }
    }
    
    