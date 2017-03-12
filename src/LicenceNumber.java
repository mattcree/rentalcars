import java.util.concurrent.atomic.AtomicInteger;

/**
 * Contains fields and behavior to represent a licence number for a Driving Licence.
 * Has a serial number which is assigned then incremented each time a new licence
 * number is created. Class is immutable and cannot be subclassed.
 */
public final class LicenceNumber {

    //Static AtomicInteger which represents the current SERIAL_NUMBER i.e.
    //the next LicenceNumber to be created will use this current value then
    //increment it. Chosen AtomicInteger due to easy to read methods but
    //could also have used a normal integer and simply incremented it
    //each time a new object is made.
    private static final AtomicInteger SERIAL_NUMBER = new AtomicInteger();
    private String initials;
    private int issueYear;
    private int serial;

    /**
     * Creates new LicenceNumber. Requires some initials and a year
     * representing the year of issue. New serial number if generated
     * for each new instance.
     * @param initials Some initials
     * @param year A year
     */
    public LicenceNumber(String initials, int year) {
        this.initials = initials;
        this.issueYear = year;
        this.serial = SERIAL_NUMBER.getAndIncrement();
    }

    //Next three accessor methods probably not required, but
    //seem potentially useful.

    /**
     * Gets the LicenceNumber's initials
     * @return A string of initials
     */
    public String getInitials() {
        return this.initials;
    }

    /**
     * Returns the year part of the licence number.
     * @return A year
     */
    public int getIssueYear() {
        return this.issueYear;
    }

    /**
     * Returns the licences serial number
     * @return A serial number
     */
    public int getSerial() {
        return this.serial;
    }

    /**
     * Returns the entire serial number as a string of the form
     * INITIALS-YEAR-SERIAL
     * @return A full licence number as a string
     */
    public String toString(){
        return this.initials + "-" + this.issueYear + "-" + this.serial;
    }

    //Package private static methods to help with tests
    //Sets the current SERIAL_NUMBER to newValue.
    protected static void setSerial(int newValue) {
        SERIAL_NUMBER.set(newValue);
    }

}
