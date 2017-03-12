import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class representing a car's Registration Number
 * of the form a0000. A new unique registration number
 * is generated upon calling 'RegistrationNumber.getInstance()'.
 */
public class RegistrationNumber {

    private static final AtomicInteger numbersCount = new AtomicInteger(0);
    private static final AtomicInteger letterCount = new AtomicInteger('a');
    private static final char LETTER_LIMIT = 'z';
    private static final int NUMBER_LIMIT = 9999;

    private char letter;
    private int numbers;

    /**
     * Private constructor for use with factory method.
     * @param letter Char representing
     * @param numbers
     */
    private RegistrationNumber(char letter, int numbers) {
        this.letter = letter;
        this.numbers = numbers;
    }

    /**
     * Factory method for returning a new RegistrationNumber instance.
     * increments numbers until max, then resets the number and increments the number.
     * e.g. a9998, a9999, b0000, b0001 ... z9999 -- will return null after z9999.
     * @return A new unique registration number
     */
    public static RegistrationNumber getInstance() {
        if (numbersCount.get() > NUMBER_LIMIT) {
            numbersCount.set(0);
            letterCount.incrementAndGet();
            if (letterCount.get() > LETTER_LIMIT) {
                return null;
            }
        }
        return new RegistrationNumber((char)letterCount.get(), numbersCount.getAndIncrement());
    }

    /**
     * Returns the letter component of the registration number.
     * @return
     */
    public char getLetter() {
        return this.letter;
    }

    /**
     * Returns the number portion of the registration number.
     * @return
     */
    public int getNumbers() {
        return this.numbers;
    }

    /**
     * Returns a string representation of a full registration number.
     * @return
     */
    public String toString() {
        return String.valueOf(letter) + String.format("%04d", numbers);
    }

    //Package Private Methods to help test getInstance()
    //without producing excessive number of objects
    static void setNumbersCount(int newNumber) {
        numbersCount.set(newNumber);
    }

    static void setLettersCount(int newLetter) {
        letterCount.set(newLetter);
    }

}
