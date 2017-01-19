
package primes;

public class Primes 
{

    private int n;
    private int[] c;
    
    /**
     * true if c is the array of all primes up to and including n
     */
    private boolean ut = false;
    
    
    public Primes(int x) 
    {
        n = x;
        c = new int[x];
    }

    public Primes() 
    {
        n = 1;
        c = new int[1];
    }

    /**
     * c to an array of the primes up to and including n
     * @return c
     */
    public int[] arrayUpTo_n() 
    {
        if(ut) return c;
        count(); 
        for (int i = 1; i <= n / 2 + 1; i++) 
        {
            if(c[i] != -1) weed(c[i]);
        }
        clean(); 
        ut = true;
        return c;
    }

    /**
     * c to an array of ints from 1 to n inclusive
     */
    private void count() 
    {
        c = new int[n];
        for (int i = 0; i < c.length; i++) 
        {
            c[i] = i + 1;
        }
    }

    /**
     * weeds out all multiples of x from c, not including x, and replaces them with -1
     * @param x 
     */
    private void weed(int x) {
        for (int i = 0; i < c.length; i++) 
        {
            if (c[i] == x) 
            {
                continue;
            }
            if (c[i] % x == 0) 
            {
                c[i] = -1;
            }
        }
    }

    /**
     * c to subset of c such that its elements do not equal 0, 1, or -1
     */
    private void clean() 
    {
        int[] d;
        int x = 0;
        for (int i = 0; i < c.length; i++) 
        {
            if (c[i] != -1 && c[i] != 1 &&c[i] != 0) x++;
        }
        d = new int[x];
        int j = 0;
        for (int i = 0; i < c.length; i++) 
        {
            if (c[i] != -1 && c[i] != 1 && c[i] != 0) 
            {
                d[j++] = c[i];
            }
        }
        c = d;

    }
    
    /**
     * boolean whether n is prime
     * @return true or false
     */
    public boolean isPrime()
    {
        if(!ut) arrayUpTo_n();
        return n == c[c.length -1];
    }
    
    /*
    * c to array of all prime factors of n
    */
    public int[] primeFact()
    {
        int x = n;
        if(!ut)arrayUpTo_n();
        int[] d = new int[c.length +1];
        int i = 0;
        int j = 0;
        while(true)
        {
            if(((double)x/(double)c[i])%1==0) 
            {
                d[j++] = c[i]; 
                x /= c[i];
            }
            else i++;
            if(x<2) break;
        }
        c = d; ut = false;
        clean(); return c;
    }
    
    /**
     * how many primes up to and including n.
     * if n is prime, which number prime?
     * @return c.length
     */
    public int numUpTo_n()
    {
        if(ut) return c.length;
        arrayUpTo_n(); return c.length;
    }

}