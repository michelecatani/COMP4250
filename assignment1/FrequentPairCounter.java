import java.util.List;
import java.util.ArrayList;;

public class FrequentPairCounter {
    
    public static ArrayList<List<Integer>> findFrequentPairs(List<List<Integer>> theList, int[][] baskets) {

        ArrayList<List<Integer>> returnedList = new ArrayList<List<Integer>>();

        for(int i = 0; i < theList.size(); ++i) {
            int firstNumber = theList.get(i).get(0);
            int secondNumber = theList.get(i).get(1);
            int count = 0;
            for(int j = 0; j < baskets.length; ++j) {
                boolean contains1 = false;
                boolean contains2 = false;
                for(int q = 0; q < baskets[j].length; ++q) {
                    if(contains1 && contains2) {
                        count++;
                        break;
                    } else if(baskets[j][q] == firstNumber) {
                        contains1 = true;
                    } else if(baskets[j][q] == secondNumber) {
                        contains2 = true;
                    }
                }
            }

            if (count > 4){
                returnedList.add(theList.get(i));
            }
        }

        return returnedList;

    }

}
