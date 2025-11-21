public class Primes 
{
    public static void main(String[] args) 
    {
        int numPrimesToCheck = Integer.parseInt(args[0]);
        
        printFinishAnswers(numPrimesToCheck);
    }

    // This function gets an int and check if hes a prime number
    public static boolean isPrime(int currentPrime)
    {
        int i = 2;
        while (i <= Math.sqrt(currentPrime)) // loop from 2 to math.sqrt to check current prime has any number which modolue it is 0
        {
            if (currentPrime % i == 0)
                return false;
            i++;
        }

        return true;
    }

    // This function goes from number 2-n and checks if the current number is prime, if so add 1 to count then return the count of primes
    public static int checkPrimes(int numPrimesToCheck)
    {
        int count = 0;
        int i = 2;

        while (i <= numPrimesToCheck)
        {
            if (isPrime(i))
                count++;
                
            i++;
        }

        return count;
    }

    // This function euns the print messages + runs the primes check and all caculations
    public static void printFinishAnswers(int numPrimesToCheck)
    {
        int primesCount = checkPrimes(numPrimesToCheck);
        int precentage = (int)((double)primesCount / (double)numPrimesToCheck * 100);

        System.out.print("There are " + primesCount + " primes between 2 and " + numPrimesToCheck + " ");
        System.out.println("(" + precentage + "% are primes)");
    }
}