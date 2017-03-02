import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class representing a car's Registration Number.
 * A new unique registration number is generated upon
 * calling 'RegistrationNumber.getInstance()'.
 */
public class RegistrationNumber {

    private static final AtomicInteger numbersCount = new AtomicInteger(0);
    private static final AtomicInteger letterCount = new AtomicInteger('a');
    private static final char letterLimit = 'z';
    private static final int numberLimit = 9999;

    private char letter;
    private int numbers;

    private RegistrationNumber(char letter, int numbers) {
        this.letter = letter;
        this.numbers = numbers;
    }

    public static RegistrationNumber getInstance() {
        if (numberIsAtMax()) {
            numbersCount.set(0);
            letterCount.incrementAndGet();
            if (letterIsAtMax()) {
                return null;
            }
        }
        return new RegistrationNumber((char)letterCount.get(), numbersCount.getAndIncrement());
    }

    public char getLetter() {
        return this.letter;
    }

    public int getNumbers() {
        return this.numbers;
    }

    public String toString() {
        return String.valueOf(letter) + String.format("%04d", numbers);
    }

    //Helpers for Instance Creation
    private static boolean letterIsAtMax() {
        return (letterCount.get() > 'z');
    }

    private static boolean numberIsAtMax() {
        return (numbersCount.get() > 9999);
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
