package leetcode;

import java.util.*;

/**
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 */
public class infected {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int a=sc.nextInt();
        sc.nextLine();
        infected obj=new infected();
        node root;
        root=obj.insert(a);
        System.out.println(obj.amounttime(root,19));
    }
    class node{
        node left,right;
        int data;
        public node(int a){
            data=a;
            left=right=null;
        }
    }
    public node insert(int a){
        node root;
        root=new node(a);
        System.out.println("enter the left of "+a);
        String le=sc.nextLine();
        if(!le.isEmpty()) {
            int l=Integer.parseInt(le);
            root.left=insert(l);
        }
        System.out.println("enter the right of "+a);
        le=sc.nextLine();
        if(!le.isEmpty()) {
            int l=Integer.parseInt(le);
            root.right=insert(l);
        }
        return root;
    }
    int maxDistance = 0;
    public int amounttime(node a,int start){
        trav(a,start);
        return maxDistance;
    }
    public int trav(node a,int s){
        int d=0;
        int lh=trav(a.left,s);
        int rh=trav(a.right,s);
        if(a.right==null&&a.left==null)d=1;
        if (a.data==s){
            maxDistance=Math.max(lh,rh);
            d=-1;
        }
        else if(lh>=0&&rh>=0)return Math.max(lh,rh)+1;
        else{
            int dis=Math.abs(lh)+Math.abs(rh);
            maxDistance=Math.max(maxDistance,dis);
            d=Math.min(lh,rh)-1;
        }
        return d;
    }
}

//    public int amounttime(node root, int start) {
//        traverse(root, start);
//        return maxDistance;
//    }
//
//    public int traverse(node root, int start){
//        int depth = 0;
//        if(root == null) return depth;
//        int leftDepth = traverse(root.left, start);
//        int rightDepth = traverse(root.right, start);
//        if(root.data == start){
//            maxDistance = Math.max(leftDepth, rightDepth);
//            depth = -1;
//
//        } else if(leftDepth>= 0 && rightDepth>= 0){
//            depth = Math.max(leftDepth, rightDepth) + 1;
//
//        } else {
//            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
//            System.out.println("maxd"+maxDistance+";;"+root.data+"depth"+depth);
//            maxDistance = Math.max(maxDistance, distance);
//            System.out.println(leftDepth+";"+rightDepth);
//            depth = Math.min(leftDepth, rightDepth) - 1;
//            System.out.println(depth);
//        }
//        return depth;
//    }


/**
 * public class infected {
 *     static Scanner sc=new Scanner(System.in);
 *     public static void main(String args[]){
 *         int a=sc.nextInt();
 *         sc.nextLine();
 *         infected obj=new infected();
 *         node root;
 *         root=obj.insert(a);
 *         System.out.println(obj.amounttime(root,3));
 *     }
 *     class node{
 *         node left,right;
 *         int data;
 *         public node(int a){
 *             data=a;
 *             left=right=null;
 *         }
 *     }
 *     public node insert(int a){
 *         node root;
 *         root=new node(a);
 *         System.out.println("enter the left of "+a);
 *         String le=sc.nextLine();
 *         if(!le.isEmpty()) {
 *             int l=Integer.parseInt(le);
 *             root.left=insert(l);
 *         }
 *         System.out.println("enter the right of "+a);
 *         le=sc.nextLine();
 *         if(!le.isEmpty()) {
 *             int l=Integer.parseInt(le);
 *             root.right=insert(l);
 *         }
 *         return root;
 *     }
 *     public int amounttime(node a,int start) {
 *         HashMap<Integer, node> par = new HashMap<>();
 *         Stack<node> itr=new Stack<>();
 *         itr.add(a);
 *         node str=null;
 *         ArrayList<node> neighbour = new ArrayList<>();
 *         ArrayList<Integer> visited = new ArrayList<>();
 *         ArrayList<node> nxt = new ArrayList<>();
 *         while(!itr.isEmpty()) {
 *             node rev;
 *             rev = itr.pop();
 *             if (rev.data == start) {
 *                 str = rev;
 *             }
 *             if (rev.right != null) {
 *                 itr.add(rev.right);
 *                 par.put(rev.right.data, rev);
 *             }
 *             if (rev.left != null) {
 *                 itr.add(rev.left);
 *                 par.put(rev.left.data, rev);
 *             }
 *         }
 *         neighbour.clear();
 *         neighbour.add(str);
 *         if (str==null)return-1;
 *         int time=-1;
 *         visited.add(str.data);
 *         while(!neighbour.isEmpty()){
 *             time++;
 *             System.out.println("time"+time);
 *             int m=neighbour.size();
 *             for(int i=0;i<m;i++){
 *                 str=neighbour.remove(0);
 *                 System.out.println("data"+str.data);
 *                 if(str.left!=null&&!visited.contains(str.left.data)){
 *                     neighbour.add(str.left);
 *                     visited.add(str.left.data);
 *                 }
 *                 if (str.right!=null&&!visited.contains(str.right.data)){
 *                     neighbour.add(str.right);
 *                     visited.add(str.right.data);
 *                 }
 *                 str=par.get(str.data);
 *                 if(str!=null&&!visited.contains(str.data)){
 *                     neighbour.add(str);
 *                     visited.add(str.data);
 *                 }
 *             }
 *         }
 *         return time;
 *     }
 * }
 */








/**
 * package leetcode;
 *
 * import java.util.ArrayList;
 * import java.util.Arrays;
 * import java.util.Scanner;
 *
 * /**
 *  * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *  *
 *  * Each minute, a node becomes infected if:
 *  *
 *  * The node is currently uninfected.
 *  * The node is adjacent to an infected node.
 *  * Return the number of minutes needed for the entire tree to be infected.
 *
 *

public class infected {
 *
    static Scanner sc = new Scanner(System.in);
 *

    public static void main(String args[]) {
 *int a = sc.nextInt();
 *sc.nextLine();
 *infected obj = new infected();
 *node root;
 *root = obj.insert(a);
 *System.out.println(obj.amounttime(root, 3));
 *}
 *

    class node {
 *
        node left, right;
 *
        int data;
 *

        public node(int a) {
 *data = a;
 *left = right = null;
 *}
 *
    }
 *

    public node insert(int a) {
 *node root;
 *root = new node(a);
 *System.out.println("enter the left of " + a);
 *String le = sc.nextLine();
 *if (!le.isEmpty()) {
 *int l = Integer.parseInt(le);
 *root.left = insert(l);
 *}
 *System.out.println("enter the right of " + a);
 *le = sc.nextLine();
 *if (!le.isEmpty()) {
 *int l = Integer.parseInt(le);
 *root.right = insert(l);
 *}
 *return root;
 *}
 *

    public ArrayList<Integer> inorder(node a) {
 *ArrayList<Integer> b = new ArrayList<>();
 *if (a == null) return null;
 *if (a.left != null) {
 *b.addAll(inorder(a.left));
        }
 *b.add(a.data);
 *if (a.right != null) {
 *b.addAll(inorder(a.right));
        }
 *return b;
 *}
 *

    public ArrayList<Integer> postorder(node a) {
 *ArrayList<Integer> b = new ArrayList<>();
 *if (a == null) return null;
 *b.add(a.data);
 *if (a.left != null) {
 *b.addAll(inorder(a.left));
        }
 *if (a.right != null) {
 *b.addAll(inorder(a.right));
        }
 *return b;
 *}
 *

    public int amounttime(node a, int start) {
 *ArrayList<Integer> post = postorder(a);
 *ArrayList<Integer> in = inorder(a);
 *ArrayList<node> neighbour = new ArrayList<>();
 *ArrayList<Integer> visited = new ArrayList<>();
 *ArrayList<node> nxt = new ArrayList<>();
 *node c = ret(a, start);
 *nxt.add(c);
 *int time = -1;
 *while (!nxt.isEmpty()) {
 *neighbour.addAll(nxt);
 *nxt.clear();
 *time++;
 *while (!neighbour.isEmpty()) {
 *node z = neighbour.remove(0);
 *if (!visited.contains(z.data)) {
 *visited.add(z.data);
 *if (z.right != null && !visited.contains(z.right.data)) {
 *nxt.add(z.right);
 *}
 *if (z.left != null && !visited.contains(z.left.data)) {
 *nxt.add(z.left);
 *}
 *c = par(z, a);
 *if (c != null && !visited.contains(c.data)) nxt.add(c);
 *}
 *}
 *}
 *return time;
 *}
 *

    public node par(node b, node a) {
 *if (a == null || b == null || a.data == b.data) return null;
 *if ((a.left != null && a.left.data == b.data) || (a.right != null && a.right.data == b.data)) return a;
 *node c = par(b, a.left);
 *if (c == null) c = par(b, a.right);
 *return c;
 *}
 *

    public node ret(node a, int start) {
 *if (a == null) return null;
 *if (a.data == start) return a;
 *node mn = null;
 *mn = ret(a.right, start);
 *if (mn == null) mn = ret(a.left, start);
 *return mn;
 *}
 *
}
 */

/**
 *     public int amounttime(node a,int start) {
 *         if (a.data==start)return height(a)-1;
 *         node str=null;
 *         str=ret(a,start);
 *         if(str.left==null&&str.right==null){
 *             return height(a.right)+height(a.left);
 *         }
 *         if (ret(a.left,start)==null){
 *             int h=height(str);
 *             int rh=height(a.right)-h+1;
 *             int c=height(a.left);
 *             if (h-1>rh+c)return rh+c;
 *             return Math.max(h-1,rh)+c;
 *         }
 *         else {
 *             int h=height(str);
 *             int rh=height(a.left)-h+1;
 *             int c=height(a.right);
 *             if (h-1>rh+c)return rh+c;
 *             return Math.max(h-1,rh)+height(a.right);
 *         }
 *     }
 *     public node ret(node a, int start){
 *         node x = null;
 *         if (a==null)return null;
 *         if (a.data==start) {
 *             return a;
 *         }
 *         if (a.left!=null&&x==null)x=ret(a.left,start);
 *         if (a.right!=null&&x==null)x=ret(a.right,start);
 *         return x;
 *         }
 *     public int height(node a){
 *         int h=1;
 *         if (a==null)return 0;
 *         if (a.left==null&&a.right==null) return 1;
 *         int leh=0;
 *         if (a.left!=null)leh+=height(a.left);
 *         int rih=0;
 *         if (a.right!=null)rih+=height(a.right);
 *         h+=Math.max(leh,rih);
 *         return h;
 *     }
 */