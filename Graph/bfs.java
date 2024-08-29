import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class bfs {

    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList <>();
        boolean vis[] = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String args[]) {
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

            ArrayList<Integer> bfs = bfsOfGraph(n,adj);
    System.out.println("");
    for(Integer i :  bfs){
        System.out.print(" " + i);
    }
    System.out.println("");
    }

}