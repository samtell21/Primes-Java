
package primes;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    
    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.print("Enter a positive int n: ");
        int n = 0;
        try
        {
            n = k.nextInt();
            if(n<=0) throw new Exception("Error: entered value is not a positive integer");
        }
        catch(InputMismatchException err)
        {
            System.out.println("Error: entered value is not an integer");
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        Primes p = new Primes(n);
        
        String s;
        s = p.isPrime()? " is ":" is not ";
        System.out.println(n+s+"a prime number");
        if(p.isPrime()) System.out.println(n + " is prime number " + p.numUpTo_n());
        
        System.out.println("Primes up to and including n: "+Arrays.toString(p.arrayUpTo_n()));
        
        System.out.println("Prime factorization of n: " +Arrays.toString(p.primeFact()));
    }
    
}
