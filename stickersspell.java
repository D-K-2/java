/**
 *     We are given n different types of stickers. Each sticker has a lowercase English word on it.
 *
 *         You would like to spell out the given string target by cutting individual letters from your collection of stickers and rearranging them. You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 *
 *         Return the minimum number of stickers that you need to spell out target. If the task is impossible, return -1.
 *
 *         Note: In all test cases, all words were chosen randomly from the 1000 most common US English words, and target was chosen as a concatenation of two random words.
 */

package leetcode;

import java.util.*;

public class stickersspell{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        String[] st=new String[a];
        for(int i=0;i<a;i++){
            st[i]=sc.next();
        }
        String tar=sc.next();
        Solution ob=new Solution();
        System.out.println(ob.minStickers(st,tar));
    }
}
class Solution {
    private boolean empty(int[] freq) {
        for(int f: freq)
            if(f > 0)
                return false;
        return true;
    }
    private String toString(int[] freq) {
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int f: freq) {
            while(f-- > 0){
                sb.append(c);
            }
            c++;
        }
        return sb.toString();
    }

    public int minStickers(String[] stickers, String target) {
        // Optimization 1: Maintain frequency only for characters present in target
        int[] targetNaiveCount = new int[26];
        for(char c: target.toCharArray()) targetNaiveCount[c - 'a']++;
        //number of times each letter is repeated in target is recorded in targetnaivecount
        int[] index = new int[26];
        int N = 0;  // no of distinct characters in target
        for(int i = 0; i < 26; i++) index[i] = targetNaiveCount[i] > 0 ? N++ : -1;
        //checks if value of targetnaivecount[i]>0 if yes assigns index[i] to n and increments it else index[-1] is set to -1
        //target naive count has the number of times each letter is repeated in target index array has which all letters are present in target
        char a='a';
        int[] targetCount = new int[N];//n =number of non repeted letters in target
        int t = 0;
        for(int c: targetNaiveCount) if(c > 0) targetCount[t++] = c;// array with number of times just the repeated letters are used in target
        int[][] stickersCount = new int[stickers.length][N];//multidimentional array with number of words*number of seprate characters;
        for(int i = 0; i < stickers.length; i++) {
            for(char c: stickers[i].toCharArray()) {
                int j = index[c-'a'];//order of particular index c in target
                if(j >= 0) stickersCount[i][j]++;//adds 1 to i,j of sticker count
                //holds how many times each letters in target are repeated in each of the words
            }
        }
        // Optimization 2: Remove stickers dominated by some other sticker
        // Perform BFS with target as source and an empty string as destination
        Queue<int[]> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Q.add(targetCount);
        int steps = 0;
        while(!Q.isEmpty()) {
            steps++;
            int size = Q.size();
            while(size-- > 0) {
                int[] freq = Q.poll();//no of times each times all the letters occour in target
                String cur = toString(freq);
                if(visited.add(cur)) {
                    // Optimization 3: Only use stickers that are capable of removing first character from current string
                    int first = cur.charAt(0) - 'a';
                    for(int i = 0; i < stickers.length; i++){
                        if(stickersCount[i][first] != 0) {
                            int[] next = freq.clone();
                            for(int j = 0; j < N; j++) next[j] = Math.max(next[j] - stickersCount[i][j], 0);
                            if(empty(next)) return steps;
                            Q.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
//"these","him","guess","about","garden"]
//        target =
//        "atomher"
//aehmort
//fly
//me
//charge
//mind
//bottom
//centorder




//public class stickersspell {
//    Scanner sc=new Scanner(System.in);
//    ArrayList<String> coll=new ArrayList<>();
//    String tar ;
//    public static void main(String[] args){
//        stickersspell obj=new stickersspell();
//        System.out.println(obj.fun());
//    }
//    public int fun(){
//        spell();
//        int a=check();
//        if (a==-1){
//            return -1;
//        }
//        int i=0;
//        while(tar.length()!=0){
//            System.out.println(i);
//            itr(coll);
//            i++;
//        }
//        return i;
//    }
//    public void spell(){
//        int a=sc.nextInt();
//        for(int i=0;i<a;i++){
//            coll.add(sc.next());
//        }
//        System.out.println("enter the target");
//        tar=sc.next();
//    }
//    public int check(){
//        //can complicate the whole logic
//        ArrayList<Character> ch=new ArrayList<>();
//        for(String a:coll){
//            char[] b=a.toCharArray();
//            for(char c:b){
//                ch.add(c);
//            }
//        }
//        for(char c:tar.toCharArray()){
//            if(ch.indexOf(c)==-1){
//                return -1;
//            }
//        }
//        return 1;
//    }
//    public void itr(ArrayList<String> b ){
//        System.out.println("array list==="+b);
//        int i=0;
//        String re=null;
//        for(String c:b){
//            System.out.println(c);
//            int[] pos=new int[26];
//            int o=0;
//            for(char d:c.toCharArray()){
//                int val=tar.indexOf(d,pos[d-'a']);
//                if(val!=-1){
//                    pos[d-'a']=val+1;
//                    o++;
//                }
//            }
//            System.out.println("word="+c+"  cur tar="+tar+"  no of times="+o);
//            if(o>i){
//                System.out.println("i="+i+"string="+c);
//                i=o;
//                re=c;
//            }
//        }
//        rem(re);
//    }
//    public void rem(String a){
//        System.out.println("removing string=="+a );
//        int[] pos=new int[26];
//        for(char b:a.toCharArray()){
//            String c=String.valueOf(b);
//            if(tar.indexOf(b)!=-1){
//                tar=tar.replaceFirst(c,"");
//                System.out.println(tar);
//            }
//        }
//    }
//}










//public class stickersspell{
//    public static void main(String args[]){
//        Scanner sc =new Scanner(System.in);
//        int a=sc.nextInt();
//        String[] st=new String[a];
//        for(int i=0;i<a;i++){
//            st[i]=sc.next();
//        }
//        String tar=sc.next();
//        Solution ob=new Solution();
//        System.out.println(ob.minStickers(st,tar));
//    }
//}

//"these","him","guess","about","garden"]
//        target =
//        "atomher"
//aehmort

//class Solution {
//    private boolean empty(int[] freq) {
//        for(int f: freq)
//            if(f > 0)
//                return false;
//        return true;
//    }
//    private String toString(int[] freq) {
//        StringBuilder sb = new StringBuilder();
//        char c = 'a';
//        for(int f: freq) {
//            while(f-- > 0){
//                sb.append(c);
//            }
//            c++;
//            System.out.println("iteration");
//        }
//        return sb.toString();
//    }
//
//    public int minStickers(String[] stickers, String target) {
//        // Optimization 1: Maintain frequency only for characters present in target
//        int[] targetNaiveCount = new int[26];
//        for(char c: target.toCharArray())
//            targetNaiveCount[c - 'a']++;
//        //number of times each letter is repeated in target is recorded in targetnaivecount
//        int[] index = new int[26];
//        int N = 0;  // no of distinct characters in target
//        for(int i = 0; i < 26; i++)
//            index[i] = targetNaiveCount[i] > 0 ? N++ : -1;
//        //checks if value of targetnaivecount[i]>0 if yes assigns index[i] to n and increments it else index[-1] is set to -1
//        //target naive count has the number of times each letter is repeated in target index array has which all letters are present in target
//        char a='a';
//        System.out.print("index array[");
//        for(int q=0;q<26;q++){
//            System.out.print(a+",  ");
//            a++;
//        }
//        System.out.println();
//        System.out.println("index array"+Arrays.toString(index));
//        int[] targetCount = new int[N];//n =number of non repeated letters in target
//        int t = 0;
//        for(int c: targetNaiveCount)
//            if(c > 0) {
//                targetCount[t++] = c;// array with number of times just the repeated letters are used in target
//            }
//        System.out.println("targetcount"+Arrays.toString(targetCount));
//        int[][] stickersCount = new int[stickers.length][N];//multidimentional array with number of words*number of seprate characters;
//        for(int i = 0; i < stickers.length; i++) {
//            for(char c: stickers[i].toCharArray()) {
//                int j = index[c - 'a'];//order of particular index c in target
//                if(j >= 0) stickersCount[i][j]++;//adds 1 to i,j of sticker count
//                //holds how many times each letters in target are repeated in each of the words
//            }
//        }
//        System.out.println("the multidimentional array"+ Arrays.deepToString(stickersCount));
//        // Optimization 2: Remove stickers dominated by some other sticker
//        int start = 0;
//        for(int i = 0; i < stickers.length; i++) {//repeats the number of stickers present
//            for(int j = start; j < stickers.length; j++) {//
//                if(j != i) {
//                    int k = 0;
//                    while(k < N && stickersCount[i][k] <= stickersCount[j][k]) {
//                        System.out.println("i,j,k"+i+""+j+""+k);
//                        System.out.println("i,k"+stickersCount[i][k] +"j,k "+ stickersCount[j][k]);
//                        k++;
//                        System.out.println("executed "+k+"n "+N);
//                        if(k<N){
//                            System.out.println("new comparison== i,k"+stickersCount[i][k] +"j,k "+ stickersCount[j][k]);
//                        }
//                        if(k == N) {
//                            int[] tmp = stickersCount[i];
//                            stickersCount[i] = stickersCount[start];
//                            System.out.println("Start bfr ==="+start);
//                            stickersCount[start++] = tmp;
//                            System.out.println("START AFTER==="+start);
//                            System.out.println(Arrays.deepToString(stickersCount));
//                            break;
//                        }
//                        System.out.println("last statement of while loop");
//                    }
//                    System.out.println("last statement of if"+j);
//                }
//                System.out.println("last statement of j loop");
//            }
//            System.out.println("last statement of i loop");
//        }
//        System.out.println("out of all loops");
//        System.out.println("final rearrangement"+Arrays.deepToString(stickersCount));
//        // Perform BFS with target as source and an empty string as destination
//        Queue<int[]> Q = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        Q.add(targetCount);
//        int steps = 0;
//        while(!Q.isEmpty()) {
//            steps++;
//            int size = Q.size();
//            System.out.println("sizeeeee"+size);
//            while(size-- > 0) {
//                int[] freq = Q.poll();//no of times each times all the letters occour in target
//                String cur = toString(freq);
//                System.out.println(Arrays.toString(freq)+",,,"+cur);
//                if(visited.add(cur)) {
//                    // Optimization 3: Only use stickers that are capable of removing first character from current string
//                    int first = cur.charAt(0) - 'a';
//                    for(int i = start; i < stickers.length; i++){
//                        if(stickersCount[i][first] != 0) {
//                            int[] next = freq.clone();
//                            for(int j = 0; j < N; j++) next[j] = Math.max(next[j] - stickersCount[i][j], 0);//changes the value of each letter of target to reduced one after removing each letter from target
//                            if(empty(next)) return steps;
//                            Q.add(next);
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}