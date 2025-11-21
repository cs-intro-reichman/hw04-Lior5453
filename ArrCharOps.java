/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    // This function prints the given array of characters, and moves the cursor to the next line.
    public static void println(char[] arr) 
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    // This function returns the char value at the specified index. Assume that the array is non-empty.
    public static char charAt(char[] arr, int index) 
    {
        return arr[index]; // index-1 becuase the array postions are from 0 and not from 1
    }

    // This function returns if the two arrays have the same value in every index
    public static boolean equals(char[] arr1, char[] arr2) 
    {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) // if value from arr1 is not same as in arr2 -> after checking if length same so no need to check other way
        {
            if (charAt(arr1, i) != charAt(arr2, i))
                return false;
        }
        return true;
    }

    // This function returns the index within the given array of the first occurrence of the given character, if not in arr return -1
    public static int indexOf(char[] arr, char ch) 
    {        
        boolean flag = false;
        int index = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (charAt(arr, i) == ch)
            {
                flag = true;
                break;
            }
            index++;
        }

        if (flag)
            return index;
        else
            return -1;
    }

    // This function is the same as indexOf(char[], char), but starts the search in the given index.
    public static int indexOf(char[] arr, char ch, int fromIndex) 
    {
        boolean flag = false;
        int index = fromIndex;

        for (int i = fromIndex; i < arr.length; i++)
        {
            if (charAt(arr, i) == ch)
            {
                flag = true;
                break;
            }
            index++;
        }

        if (flag)
            return index;
        else
            return -1;
    }

    //This function returns the index within the given arr of the last occurrence of the given character, if not in arr return -1
    public static int lastIndexOf(char[] arr, char ch) 
    {
        boolean flag = false;
        int index = arr.length - 1;

        for (int i = index; i > 0; i--)
        {
            if (charAt(arr, i) == ch)
            {
                flag = true;
                break;
            }
            index--;
        }

        if (flag)
            return index;
        else
            return -1;
    }

    // This function will return an array which is the concatanation of the two given arrays.
    public static char[] concat(char[] arr1, char[] arr2) 
    {
        char[] newArr = new char[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) // adding first array elemnts
        {
            newArr[i] += arr1[i];
        }
    
        int arr2Index = 0; // second array index counter for adding second array elemnts
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) // adding seocond array elemnts
        {
            newArr[i] += arr2[arr2Index];
            arr2Index++;
        }

        return newArr;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) 
    {
        char[] newArr;
        if (beginIndex == 0)
            newArr = new char[arr.length - endIndex];
        else
            newArr = new char[arr.length - beginIndex];

        int newArrIndex = 0; // index of new array because using index of the substring in the loop to get the elemnts to add
        for (int i = beginIndex; i < endIndex; i++)
        {
            newArr[newArrIndex] += arr[i];
            newArrIndex++;
        }


        return newArr;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) 
    {
        if (arr.length == 0)
            return 0;

        long hash = 0;
        for (int i = 0; i < arr.length; i++)
        {
            hash += arr[i] * Math.pow(7, (arr.length - i - 1));
        }
        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) 
    {
        if (str1.length() == 0 || str2.length() == 0) // if input is incorrect
            return -2;

        // Testing equal str length
        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) > str2.charAt(i))
                return 1;
            else if (str1.charAt(i) < str2.charAt(i)) 
                return -1;
        }

        // Checking strings length
        if (str1.length() < str2.length()) 
            return -1;

        if (str1.length() > str2.length())
            return 1;
        
        return 0; // if passed all tests return 0 because equals
    }
}