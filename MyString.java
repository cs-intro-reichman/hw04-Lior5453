public class MyString 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    // This function returns the lowercase version of the given string.
    public static String lowerCase(String str) 
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >=  65 && str.charAt(i) <= 90) // if uppercased hex value change it to lower case value
                newStr += (char)(str.charAt(i) + 32); // getting the hex value to lower case then turnning it into char
            else
                newStr += str.charAt(i);
        }
     
        return newStr;
    }

    // This function checks if str1 contains str2, returns true; otherwise returns false.
    public static boolean contains(String str1, String str2) 
    {
        if (str2.length() == 0) // if str2 conatins nothing str1 always contains it
            return true;

        if (str1.length() < str2.length()) // if str1 smaller then str2 return false because it cant contain it
            return false;

        if (str1.length() == str2.length()) // if both lengths are the same
        {
            for (int i = 0; i < str1.length(); i++) 
            {
                if (str1.charAt(i) != str2.charAt(i))
                    return false;
            }  
            return true;
        }
        
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) // loop to run for all the "extra" letters to check if string starts there
        {
            if (str1.charAt(i) != str2.charAt(0))
                continue; // if not same keep going for next i

            int count = 0;
            while ((count < str2.length()) && (str2.charAt(count) == str1.charAt(i + count))) 
                count++; // while characters are same add one then check if same length as str2 length

            if (count == str2.length())
                return true;
        }
        return false;
    }
}