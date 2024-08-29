import java.util.*;

class dfs{
    public static void dfsOfGraph1(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);

        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                dfsOfGraph1(i,vis,adj,ls);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V+1];
        vis[1] = true;
        ArrayList<Integer> ls = new ArrayList <>();
        dfsOfGraph1(1,vis,adj,ls);
        return ls;
    }


    public static void main(String args[]){
        int n = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).addAll(Arrays.asList(2, 6));
        adj.get(2).addAll(Arrays.asList(1, 3, 4));
        adj.get(3).addAll(Arrays.asList(2));
        adj.get(4).addAll(Arrays.asList(2, 5));
        adj.get(5).addAll(Arrays.asList(4, 8));
        adj.get(6).addAll(Arrays.asList(1, 7, 9));
        adj.get(7).addAll(Arrays.asList(6, 8));
        adj.get(8).addAll(Arrays.asList(5, 7));
        adj.get(9).addAll(Arrays.asList(6));

            ArrayList<Integer> bfs = dfsOfGraph(n,adj);
    System.out.println("");
    for(Integer i :  bfs){
        System.out.print(" " + i);
    }
    System.out.println("");      
    }
}