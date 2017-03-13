import java.util.Calendar;
import java.util.Date;

/**
 * All fields and behavior for a DrivingLicence object. Represents a real world
 * driving licence. Class is immutable and cannot be subclassed.
 */
public final class DrivingLicence {

    //static Calendar to help with date creation for instances.
    private static final Calendar CALENDAR = Calendar.getInstance();
    private Name name;
    private Date dob;
    private Date issueDate;
    private boolean licenseStatus;
    private LicenceNumber licenceNumber;

    /**
     * Constructor for a DrivingLicence. All params required.
     * @param name A Name for the licence holder.
     * @param dob The licence holder's date of birth.
     * @param licenseStatus True if the licence is full, false if not full.
     */
    public DrivingLicence(Name name, Date dob, Date issueDate, boolean licenseStatus){
        this.name = name;
        this.dob = dob;
        //Assumed that the issueDate should be the same
        //as the time the license is created.
        this.issueDate = issueDate;
        this.licenseStatus = licenseStatus;
        CALENDAR.setTime(issueDate);
        this.licenceNumber = new LicenceNumber(name.getInitials(), CALENDAR.get(Calendar.YEAR));
    }

    /**
     * Returns name of licence holder.
     * @return A Name
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns licence holder's date of birth
     * @return A Date
     */
    public Date getDateOfBirth() {
        return new Date(dob.getTime());
    }

    /**
     * Returns the status of the licence.
     * @return True if licence is a full licence, false if not.
     */
    public boolean isFullLicense() {
        return licenseStatus;
    }

    /**
     * Returns the date the licence was issued. Automatically
     * generated when object is created.
     * @return A Date
     */
    public Date getIssueDate() {
        return new Date(issueDate.getTime());
    }

    /**
     * Returns the licence number
     * @return A LicenceNumber
     */
    public LicenceNumber getLicenceNumber() {
        return licenceNumber;
    }

    /**
     * Overrides Object equals method. Will return
     * true if this licence has the same licence
     * as the param licence.
     * @param object Object to be compared to
     * @return True if this object has same licence number as param object.
     * False if param object is different class or null.
     */
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;

        DrivingLicence that = (DrivingLicence) object;

        return licenceNumber.equals(that.licenceNumber);
    }

    /**
     * Returns hashCode based on licence number.
     * @return An integer for use by hashable data structures.
     */
    public int hashCode() {
        return licenceNumber.hashCode();
    }

    public static int differenceInYears(Date pastDate, Date today) {
        int millisecondsInASecond = 1000;
        int secondsInAYear = 31556926;
        long differenceInMilliseconds = today.getTime() - pastDate.getTime();
        return (int)(differenceInMilliseconds / millisecondsInASecond) / secondsInAYear;
    }

}
