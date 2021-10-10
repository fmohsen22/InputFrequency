import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFreqElm {
    static List<Integer> mostFrequent(int arr[], int n)
    {

        // create a map for each unique element and its frequency
        Map<Integer, Integer> frequencyMap =
                new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++)
        {
            int key = arr[i];
            // If the elemet is repeated then count the frequency, otherwise freq=1
            if(frequencyMap.containsKey(key))
            {
                int freq = frequencyMap.get(key);
                freq++;
                frequencyMap.put(key, freq);
            }
            else
            {
                frequencyMap.put(key, 1);
            }
        }


        int max_count = 0;
        // If there are several intigers with the same frquency then we can add all or them in the list
        List<Integer> res=new ArrayList<Integer>();

        for(Map.Entry<Integer, Integer> val : frequencyMap.entrySet()){
            // if there is just one number with highest frequency
            if (max_count < val.getValue()){
                res.clear();
                res.add(val.getKey());
                max_count = val.getValue();
            }
            // if there are many with the same frequency
            else if (max_count == val.getValue()){
                res.add(val.getKey());
            }
        }
        return res;
    }

    // Driver code
    public static void main (String[] args) {

        int arr[] = {1,5,2,2,2, 5,5,5,5,5, 2, 1, 3, 2, 1,1,1,1};
        int n = arr.length;

        System.out.println(mostFrequent(arr, n));
    }
}
