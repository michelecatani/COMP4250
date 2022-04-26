import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Question4 {
    
    public static void main(String[] args) {
        
        int[][] baskets = new int[101][101];

        for(int basket = 1; basket < 101; ++basket) {
            int index = 0;
            for(int i = 1; i < 101; ++i) {
                if(i % basket == 0) {
                    baskets[basket][index++] = i;
                }
            }
        }

        int largestBasket = 0;
        int largestBasketAmount = 0;
        int[] counts = new int[101];

        for(int i = 1; i < baskets.length; ++i) {
            System.out.print("Basket " + Integer.toString(i) + ": ");
            int count = 0;
            for (int j = 0; baskets[i][j] != 0; ++j) {
                System.out.print(Integer.toString(baskets[i][j]) + " ");
                counts[baskets[i][j]]++;
                count ++;
            }

            if(count > largestBasketAmount) {
                largestBasket = i;
                largestBasketAmount = count;
            }

            System.out.println();
        }

        ArrayList<Integer> frequentSingletons = new ArrayList<Integer>();

        for(int i = 1; i < 101; ++i) {
            // System.out.println(i + " has " +  counts[i]);
            if(counts[i] > 4) {
                frequentSingletons.add(i);
            }
        }

        ArrayList<List<Integer>> allPairs = new ArrayList<List<Integer>>();

        for(int i = 0; i < frequentSingletons.size(); ++i) {
            for(int j = i + 1; j < frequentSingletons.size(); ++j) {
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(frequentSingletons.get(i));
                newList.add(frequentSingletons.get(j));
                allPairs.add(newList);
            }
        }

        ArrayList<List<Integer>> frequentPairs = FrequentPairCounter.findFrequentPairs(allPairs, baskets);

        System.out.println("The largest basket is: " + largestBasket);
        System.out.println("The largest basket count is: " + largestBasketAmount);

        System.out.println("The frequent singletons are: ");
        for(int i = 0; i < frequentSingletons.size(); ++i) {
            System.out.print(frequentSingletons.get(i) + " ");
        }

        System.out.println("\nThe frequent pairs are: ");
        for(int i = 0; i < frequentPairs.size(); ++i) {
            System.out.print(frequentPairs.get(i)+",");
        }
    }
}
