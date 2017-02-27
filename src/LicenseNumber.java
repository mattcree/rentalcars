import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Cree on 24/02/2017.
 */
public class LicenseNumber {

    private static final AtomicInteger serialNumber = new AtomicInteger();
    private String initials;
    private Date issueDate;
    private int serial;

    private LicenseNumber (String initials, Date date, int serial) {
        this.initials = initials;
        this.issueDate = new Date();
        this.serial = serial;
    }
}
