//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class ProblemSetTest {

   //Create your tests here if you want any


   //Example Test
   
   @Test
   public void exampleTest()
   {
      Card queen = new Card("Queen", "Heart", 13);
      Card king = new Card("King", "Spade", 14);
      System.out.println(queen.equals(new Object[]{null}));
   }
}
