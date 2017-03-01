import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Cree on 24/02/2017.
 */
public class LicenseNumber {

    private static final AtomicInteger SERIAL_NUMBER = new AtomicInteger();
    private String initials;
    private int issueYear;
    private int serial;

    public LicenseNumber (String initials, int year) {
        this.initials = initials;
        this.issueYear = year;
        this.serial = SERIAL_NUMBER.getAndIncrement();
    }

    public String getInitials() {
        return this.initials;
    }

    public int getIssueYear() {
        return this.issueYear;
    }

    public int getSerial() {
        return this.serial;
    }

    public String getLicenseNumber(){
        return this.initials + "-" + this.issueYear + "-" + this.serial;
    }

    //Package private methods to help with tests
    static void setSerial(int newValue) {
        SERIAL_NUMBER.set(newValue);
    }

}
