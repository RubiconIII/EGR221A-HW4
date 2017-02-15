/**
 * Created by curti_000 on 2/7/2017.
 */
public class LetterInventory {

    // A LetterInventory stores an inventory of the letters in a given String.
    // These Letter Inventories may be set, added, and subtracted.

    private int[] counter;
    private static final int LETTER_COUNT = 26;
    private int size;

    // Post- Returns the character in lowCharHelper case.
    private char lowCharHelper(char l) { return Character.toLowerCase(l); }

    // Post- Constructs an inventory. Empty.
    public LetterInventory() {
        this("");
    }

    // Pre- String is passed into LetterInventory.
    // Post- Constructs an Inventory of the letters within the passed in word.
    public LetterInventory(String data) {
        this.size = 0;
        this.counter = new int[LETTER_COUNT];
        for (int i = 0; i < data.length(); i++) {
            char l = lowCharHelper(data.charAt(i));
            if (l >= 'a' && l <= 'a' + LETTER_COUNT - 1) {
                this.counter[l - 'a']++;
                this.size++;
            }
        }
    }

    // Pre- If a non-alphabetic letter is given, throws IllegalArgumentException.
    // Post- Returns the number of times the passed in letter
    // appears in the inventory.
    public int get(char c) {
        if (!Character.isLetter(c)) {
            throw new IllegalArgumentException("Non Alphabetic Letter");
        } else {
            char l = lowCharHelper(c);
            return this.counter[l - 'a'];
        }
    }

    // Pre-If a non-alphabetic letter is given, throws IllegalArgumentException.
    // Post- Sets the count for the passed in letter to the passed in value.
    public void set(char letter, int value) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Non Alphabetic Letter");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value Negative");
        } else {
            char l = lowCharHelper(letter);
            this.size -= this.counter[l - 'a'];
            this.counter[l - 'a'] = value;
            this.size += value;
        }
    }

    // Post- Returns the sum of the counts in inventory.
    public int size() {
        return this.size;
    }

    // Post- Returns true if all counts in the inventory are 0.
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Post- Returns a String representation of this inventory.
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.counter.length; i++) {
            int ct = this.counter[i];
            if (ct > 0) {
                for (int j = 0; j < ct; j++) {
                    s += (char) ('a' + i);
                }
            }
        }
        return s + "]";
    }

    // Post- Returns a new LetterInventory that shows
    // the sum of this.inventory and other (passed in) inventory.
    public LetterInventory add(LetterInventory other) {
        LetterInventory l = new LetterInventory();
        for (int i = 0; i < LETTER_COUNT; i++) {
            int sum = this.counter[i] + other.counter[i];
            l.counter[i] = sum;
            l.size += sum;
        }
        return l;
    }

    // Post- Returns new LetterInventory that shows
    // the difference of subtracting other inventory
    // from this.inventory.
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory l = new LetterInventory();
        for (int i = 0; i < LETTER_COUNT; i++) {
            int diff = this.counter[i] - other.counter[i];
            if (diff < 0) {
                return null;
            }
            l.counter[i] = diff;
            l.size += diff;
        }
        return l;
    }

        // Pre-If a non-alphabetic letter is given, throws IllegalArgumentException.
        // Post- Returns double showing the percentage
        // of letters in this.inventory that match the passed in char.
        public double getLetterPercentage(char letter) {
            if (!Character.isLetter(letter)){throw new IllegalArgumentException("Non Alphabetic Letter");}
            if (!this.isEmpty()) {
                return (double) this.counter[lowCharHelper(letter) - 'a'] / this.size;
            }
            return 0.0;
        }
    }