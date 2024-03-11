package leetcode;

import java.util.Scanner;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */

public class longest_palindrome {
    static Scanner sc =new Scanner(System.in);
    public static void main(String args[]){
        longest_palindrome obj=new longest_palindrome();
        System.out.println("enter the string :");
        String s=sc.next();
        System.out.println(obj.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        char[] st=s.toCharArray();
        int l=st.length;
        int max=1;
        String str=s.substring(0,1);
        for(int i=0;i<l;i++){
            int t1=i;
            int j=1;
            int j2=0;
            int re=0;
            while((t1-j)>=0&&(t1+j2)<l&&(st[t1+j2]==st[t1-j])){
                System.out.println(t1+"j"+j+"j2"+j2);
                re+=2;
                j++;
                j2++;
            }
            if(re>max){
                System.out.println(t1+"j"+j+"j2"+j2+"here");
                max=re;
                str=s.substring(t1-j+1,t1+j2);
            }
            j=0;
            re=-1;
            while(j<=t1&&(j+t1)<l&&st[t1-j]==st[t1+j]){
                System.out.println(t1+"j"+j+"j2 "+j2+"should not enter");
                re+=2;
                j++;
            }
            if(re>max){
                max=re;
                System.out.println(t1+"j"+j+"j2"+j2+"2nd");
                str=s.substring(t1-j+1,t1+j);
            }
        }
        return str;
    }
}
