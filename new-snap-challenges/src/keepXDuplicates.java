import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * This program takes an array of integers and keeps 'x' number of
 * duplicates entries.
 * @author Jaeren Tredway
 * @version 1.0
 */
public class keepXDuplicates {
    /**
     *
     * @param args Command line arguments are ignored
     */
    public static void main(String[] args) {
        int[] testArray = { 1, 1, 3, 3, 3, 7, 2, 2, 2, 2, 2};
//        int[] testArray = { 21, 22, 23 };
        int maxOccurrences = 3;

        deleteNth(testArray, maxOccurrences);
    }

    /**
     * This method pairs down an input array as described below:
     * @param elements array of integers
     * @param maxOccurrences the max number of duplicate entries to return
     * @return returns a new array with only the 'maxOccurrence' number of any
     * given element
     */
    private static int[] deleteNth(int[] elements, int maxOccurrences) {
        //result list must be flexible length:
        List<Integer> preResult = new ArrayList<>();


        //Create a HashMap object:
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();

        //check for bogus input:
        if (elements == null || elements.length == 0 || maxOccurrences == 0) {
            return new int[0];
        }

        // add an input array element to the preResult list if # of
        // occurrences are still acceptable, and update the map:
        for (int element : elements) {
            System.out.println("next input element: " + element);
            if (!preResult.contains(element) || elementCountMap.get(element) < maxOccurrences) {
                preResult.add(element);
                //if element is already present in the map, increment it's
                // count in the map by 1:
                if (elementCountMap.containsKey(element)) {
                    elementCountMap.put(element, elementCountMap.get(element) + 1);
                } else {
                    //if element is not already present in the map, add it to
                    // the map with 1 as it's value:
                    elementCountMap.put(element, 1);
                }
                System.out.println("current map state: " + elementCountMap);
                System.out.println("current preResult list state: " + preResult);
                System.out.println("the element '" + element + "' occurs " +
                    "in the results " + elementCountMap.get(element) + " " +
                        "times so far.\n");
            }
        }


        //populate final result array with preResult list values:
        int[] result = new int[preResult.size()];
        for (int i = 0; i< preResult.size(); i++) {
            result[i] = preResult.get(i);
        }

        System.out.println(preResult);
        return result;
    }
}
