import java.util.ArrayList;

class list_graph{
    public static void main(String args[]){
        int n = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1); // for undirected graph
    }
}