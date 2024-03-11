/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class ransomnote {
    public static void main(String args[]){

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countLetter = new int[26];
        for(char c: ransomNote.toCharArray()){
            int place = magazine.indexOf(c, countLetter[c - 'a']);
            if(place == -1){
                return false;
            }
            countLetter[c - 'a'] = place + 1;
        }
        return true;
    }
}


/**
 *     public static void main (String []args){
 *           Scanner sc=new Scanner(System.in);
 *           String a=sc.next();
 *           String b=sc.next();
 *           boolean d=true;
 *           for(char c :a.toCharArray()){
 *               if(b.indexOf(c)==-1){
 *                   d=false;
 *                   break;
 *               }
 *               else{
 *                   b=b.substring(0,b.indexOf(c))+b.substring(b.indexOf(c)+1);
 *               }
 *           }
 *           System.out.println(d);
 *       }
 *         public static void main (String []args){
 *         Scanner sc=new Scanner(System.in);
 *         String b= sc.next();
 *         String e= sc.next();
 *         boolean flag= true;
 *         for(char a:b.toCharArray()){
 *             int c=e.indexOf(a);
 *             if(c==-1){
 *                 flag=false;
 *             }
 *             else{
 *                 e=e.substring(0,c)+e.substring(c+1);
 *             }
 *         }
 *         System.out.println(flag);
 *     }
 */

// if (magazine.length() < ransomNote.length()) return false;
//
//        int[] character_counter = new int[26];
//
//        for (char c : magazine.toCharArray()) {
//        character_counter[c - 'a'] ++ ;
//        }
//
//        for (char c: ransomNote.toCharArray()) {
//        if (--character_counter[c - 'a'] < 0) {
//        System.gc();
//        return false;
//        }
//        }
//        System.gc();
//        return true;



//{
//public static void main(String args[]){
//        Scanner sc=new Scanner(System.in);
//        System.out.println(tof(sc.nextLine(), sc.nextLine()));
//        }
//public static boolean tof(String ransom,String mag){
//        int[] chara =new int[26];
//        for(char c:mag.toCharArray()){
//        chara[c-'a']++;
//        }
//        for(char c:ransom.toCharArray()){
//        if(--chara[c-'a']<0){
//        return false;
//        }
//        }
//        return true;
//        }
//
//        }