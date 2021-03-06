import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsets(S, S.length-1);
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] S, int idx){
        if (idx == -1){
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> emptySet = new ArrayList<Integer>();
            result.add(emptySet);
            return result;
        }
        else{
            ArrayList<ArrayList<Integer>> lastLayer = subsets(S, idx-1);
            ArrayList<ArrayList<Integer>> curLayer = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> set: lastLayer){
                ArrayList<Integer> newSet = copyList(set);
                newSet.add(S[idx]);
                curLayer.add(newSet);
            }
            lastLayer.addAll(curLayer);
            return lastLayer;
        }
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> l){
        ArrayList<Integer> newL = new ArrayList<Integer>();
        for (Integer i: l){
            newL.add(i);
        }
        return newL;
    }

    public static void main(String[] args){
        int[] A = {4,1,0};
        ArrayList<ArrayList<Integer>> result = new Subset().subsets(A);
        for (ArrayList<Integer> set: result){
            for (Integer i: set){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
