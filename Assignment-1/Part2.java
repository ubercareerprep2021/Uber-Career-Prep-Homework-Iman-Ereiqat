package com.company;

import java.util.*;

public class Main 
{

    public static void main(String[] args)
    {
        System.out.println("isStringPerumtation test case s1: 'asdf', s2: 'fsda' = "
                + isStringPermutation("asdf", "fsda"));
        System.out.println("isStringPerumtation test case s1: 'asdf', s2: 'fsa' = "
                + isStringPermutation("asdf", "fsa"));
        System.out.println("isStringPerumtation test case s1: 'asdf', s2: 'fsax' = "
                + isStringPermutation("asdf", "fsax") + "\n");


        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("pairsThatEqualSum test case inputArray: [1, 2, 3, 4, 5], targetSum: 5 = "
        + pairsThatEqualSum(input, 5));
        System.out.println("pairsThatEqualSum test case inputArray: [1, 2, 3, 4, 5], targetSum: 1 = "
                + pairsThatEqualSum(input, 1));
        System.out.println("pairsThatEqualSum test case inputArray: [1, 2, 3, 4, 5], targetSum: 7 = "
                + pairsThatEqualSum(input, 7));
    }


    /**************/

    // Function isStringPermutation()
    //
    // Takes two Strings as parameters
    // and returns a Boolean denoting whether the first string is
    // a permutation of the second string.
    // Assuming all characters will be lowercase
    //
   public static boolean isStringPermutation(String s1, String s2)
   {
       if (s1.length() != s2.length())
       {
           return false;
       }
       else
       {
           for (int i = 0; i < s1.length(); i++)
           {
               char s = s1.charAt(i);
               if (s2.contains(String.valueOf(s)))
               {
                   continue;
               }
               else
               {
                   return false;
               }
           }
       }
       return true;
   }

    // pairsThatEqualSum()
    //
    // Takes an array of integers and a target integer and returns an array of
    // pairs (i.e., an array of tuples) where each pair contains two numbers from
    // the input array and the sum of each pair equals the target integer.
    // (Order of the output does not matter).
    //
    public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum)
    {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < inputArray.size(); i++)
        {
            int current = inputArray.get(i); 

            for (int j = i + 1; j < inputArray.size(); j++)
            {
                if (current + inputArray.get(j) == targetSum)
                {
                    result.add(Arrays.asList(current, inputArray.get(j)));
                }
                else
                {
                    continue;
                }
            }
        }
        return result;
    }
}
