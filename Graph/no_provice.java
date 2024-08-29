import java.util.ArrayList;
import java.util.Arrays;

public class no_provice{
    public static void dfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer i : adj.get(node)){
            if(!vis[(int)i]){
                dfs(i,vis,adj);
            }
        }
    }

    public static int no_province(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V+1];
        int number = 0;
        for(int i = 1;i<=V;i++){
            if(!vis[i]){
                number++;
                dfs(i,vis,adj);
            }
        }
        return number;

    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        final int V = 8;
        for(int i = 0; i<= V;i++){
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).addAll(Arrays.asList(2));
        adj.get(2).addAll(Arrays.asList(1,3));
        adj.get(3).addAll(Arrays.asList(2));
        adj.get(4).addAll(Arrays.asList(5));
        adj.get(5).addAll(Arrays.asList(4,6));
        adj.get(6).addAll(Arrays.asList(5));
        adj.get(7).addAll(Arrays.asList(8));
        adj.get(8).addAll(Arrays.asList(7));
        int num = no_province(V,adj);
        System.out.println(num);
    }
}