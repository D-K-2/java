package leetcode;

import base.oops;

import java.util.Scanner;

public class sumpath {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        node root;
        sumpath obj=new sumpath();
        int a=sc.nextInt();
        sc.nextLine();
        root=obj.insert(a);
        System.out.println(obj.maxx(root));
    }
    class node{
        node left;
        node right;
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
    int larval=Integer.MIN_VALUE;
    public int maxx(node a){
        maxPathSum(a);
        return larval;
    }

    public int maxPathSum(node root) {
        if (root==null)return 0;
        int lm=maxPathSum(root.left);
        int rm=maxPathSum(root.right);
        int ma=Math.max(lm,rm);
        int mi=(ma==lm)?rm:lm;
        if (root.left==null&&root.right==null)larval=Math.max(larval,root.data);
        else{
            if (ma<0){
                larval=Math.max(larval, root.data);
                return root.data;
            }
            int m=Math.max(ma,ma+mi);
            larval=Math.max(larval,root.data+m);
        }
//        else {
//             if(lm>rm){
//                 if(lm<0){
//                     larval=Math.max(larval,root.data);
//                     return root.data;
//                 }
//                 else{int m=Math.max(lm,lm+rm);
//                     larval=Math.max(larval,m+root.data);}
////                 System.out.println(larval);
////                 System.out.println(root.data);
//             }
//             else{
//                 if(rm<0){
//                     larval=Math.max(larval,root.data);
//                     return root.data;
//                 }
//                 else{int m=Math.max(rm,lm+rm);
//                     larval=Math.max(larval,m+root.data);}
////                 System.out.println(larval);
////                 System.out.println(root.data);
//             }
//        }
        return ma+ root.data;
    }
}
