package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 */
public class informemp {
    static Scanner sc =new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("enter the number of employes");
        int n=sc.nextInt();
        System.out.println("enter the headid'");
        int headId=sc.nextInt();
        int[] manager =new int[n];
        int[] informTime=new int[n];
        for(int i=0;i<n;i++){
            if (i==headId)manager[i]=-1;
            else manager[i]=sc.nextInt();
            System.out.println("enter the inform time");
            informTime[i]= sc.nextInt();
        }
        informemp obj=new informemp();
        System.out.println(obj.numOfMinutes(n,headId,manager,informTime));
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int tim=0;
        for(int i=0;i<n;i++){
            if(informTime[i]==0){
                continue;
            }
            tim=Math.max(tim,tot(i,manager,informTime));
        }
        return tim;
    }
    public int tot(int a,int[] b,int[]c){
        int tim=0;
        while(a!=-1){
            tim+=c[a];
            a=b[a];
        }
        return tim;
    }
}
