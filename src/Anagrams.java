import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by curti_000 on 2/21/2017.
 */
public class Anagrams
{
    List<String> dictionary;
    Map<String, LetterInventory> map = new HashMap<String, LetterInventory>();

    /**PRE: Takes in a list.
     *
     * POST: This method constructs an Anagrams that will utilize the passed in
     * list as its dictionary.
     */
    public Anagrams(List<String> list) {
        dictionary = list;
        for (int i = 0; i < dictionary.size(); i++) {
            map.put(dictionary.get(i),
                    new LetterInventory(dictionary.get(i)));
        }
    }

    /**PRE: This method
     * throws an IllegalArgumentException if the given max
     * is less than zero. Takes in string s and int max.
     *
     * POST: This method finds words
     * (according to the given max) that contain the same
     * letters as the passed in s and prints them.
     */
    public void result(String s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }

        LetterInventory l = new LetterInventory(s);
        List<String> prunedDictionary = new ArrayList<String>();
        List<String> results = new ArrayList<String>();
        if (max == 0){max = l.size();}

        for (int i = 0; i < dictionary.size(); i++) {
            String temp = dictionary.get(i);
            if (l.subtract(map.get(temp)) != null) {
                prunedDictionary.add(temp);
            }
        }
        resultHelper(l, results, max, prunedDictionary);
    }

    /** PRE: Takes in letters, res, max, and dictionary
     *
     * POST:The helper method searches through the
     * passed in dictionary to find each combination
     * of words that have the same letters as the passed in string
     */
    private void resultHelper(LetterInventory letters, List<String> res, int max, List<String> dictionary) {
        LetterInventory let;
        if (letters.isEmpty()) {
            System.out.println(res);

        } else if (res.size() >= max) {
            return;

        } else {

            for (int i = 0; i < dictionary.size(); i++) {
                String s = dictionary.get(i);
                let = letters.subtract(map.get(s));

                if (let != null) {
                    res.add(s);
                    resultHelper(let, res, max, dictionary);
                    res.remove(res.size() - 1);
                }
            }
        }

    }
}