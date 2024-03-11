package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * There exists an undirected and initially unrooted tree with n nodes indexed from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * Each node has an associated price. You are given an integer array price, where price[i] is the price of the ith node.
 *
 * The price sum of a given path is the sum of the prices of all nodes lying on that path.
 *
 * The tree can be rooted at any node root of your choice. The incurred cost after choosing root is the difference between the maximum and minimum price sum amongst all paths starting at root.
 *
 * Return the maximum possible cost amongst all possible root choices.
 */
public class maxminprice {
    static Scanner sc =new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("enter the number of edges");
        int n=sc.nextInt();
        sc.nextLine();
        int[][] edge=new int[n-1][2];
        int[] price=new int[n];
        for(int i=0;i<n-1;i++){
            System.out.println("enter the edge pairs");
            for (int m=0;m<2;m++){
                edge[i][m]= sc.nextInt();
                System.out.println(edge[i][m]);
            }
        }
        System.out.println("enter the price");
        for(int i=0;i<n;i++)price[i]=sc.nextInt();
        maxminprice obj=new maxminprice();
        System.out.println(obj.maxOutput(n,edge,price));
    }
    long res = 0;
    List<Integer>[] g;
    int[] price;

    record returnType(int withLeaf, int withoutLeaf) {}
    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;

        // create adjacency list graph(tree)
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (var e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(0, -1); // you can start from any root doesn't matter, as long as it exists
        return res;
    }

    private returnType dfs(int cur, int pre) {
        int withLeaf = price[cur], withoutLeaf = 0;
        for (int child : g[cur]) if (child != pre) {
            var childMax = dfs(child, cur);
            res = Math.max(res, withLeaf + childMax.withoutLeaf);
            res = Math.max(res, withoutLeaf + childMax.withLeaf);
            withLeaf = Math.max(withLeaf, childMax.withLeaf + price[cur]);
            withoutLeaf = Math.max(withoutLeaf, childMax.withoutLeaf + price[cur]);
        }
        System.out.println(withLeaf+"l"+ withoutLeaf+"ol"+cur);
        return new returnType(withLeaf, withoutLeaf); // single leg
    }
}
//[[0,1],[1,2],[1,3],[3,4],[3,5]]

//    public long maxOutput(in
//
//
//
//    t n, int[][] edges, int[] price) {
//        int[][] con=new int[n][n];
//        for(int[] a:edges){
//            con[a[0]][a[1]]=1;
//            con[a[1]][a[0]]=1;
//        }
//        int dis=Integer.MIN_VALUE;
//        for (int i=0;i<n;i++){
//            int[] vis=new int[n];
//            vis[i]=1;
//            int[] ml=de(i,price,edges,vis);
//            dis=Math.max(dis,ml[0]-ml[1]);
//        }
//        return dis;
//    }

//    public int[] de(int n, int[] a, int[][] b, int[] vis){
//        int ld=Integer.MAX_VALUE;
//        int md=Integer.MIN_VALUE;
//        int[][] nod=new int[b.length][2];
//        for (int i=0;i<b.length;i++){
//            if (b[n][i]==1&&vis[i]!=1){
//                int[] v= Arrays.copyOf(vis,vis.length);
//                v[i]=1;
//                nod[i]= de(i, a, b, v);
//            }
//        }
//        for(int[] i:nod){
//            ld=Math.min(ld,i[1]);
//            md=(i[0]>md)?i[0]:md;
//        }
//        if (md<0)md=0;
//        if(ld>0)ld=-a[n];
//        return new int[]{md+a[n], ld+a[n]};
//    }

//    public int lde(int n, int[] a, int[][] b, int[] vis){
//        int ld=Integer.MAX_VALUE;
//        int[] nod=new int[b.length];
//        for (int i=0;i<a.length;i++){
//            if(b[n][i]==1&&vis[i]!=1){
//                int[] v=new int[vis.length];
//                System.arraycopy(vis,0,v,0,vis.length);
//                v[i]=1;
//                nod[i]=lde(i,a,b,v);
//            }
//        }
//        for(int i:nod){
//            ld=Math.min(ld,i);
//        }
//        if (ld>0)return 0;
//        return ld+a[n];
//    }
//    public int mde(int n, int[] a, int[][] b, int[] vis){
//        int md=Integer.MIN_VALUE;
//        int[] nod=new int[b.length];
//        for (int i=0;i<b.length;i++){
//            if (b[n][i]==1&&vis[i]!=1){
//                int[] v= Arrays.copyOf(vis,vis.length);
//                v[i]=1;
//                nod[i]= mde(i, a, b, v);
//            }
//        }
//        for (int i:nod){
//            md=(i>md)?i:md;
//        }
//        if(md<0)return a[n];
//        return md+a[n];
//    }