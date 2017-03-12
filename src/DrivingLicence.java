import java.util.Calendar;
import java.util.Date;

/**
 * All fields and behavior for a DrivingLicence object. Represents a real world
 * driving licence.
 */
public class DrivingLicence {

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
    public DrivingLicence(Name name, Date dob, boolean licenseStatus){
        this.name = name;
        this.dob = dob;
        //Assumed that the issueDate should be the same
        //as the time the license is created.
        this.issueDate = CALENDAR.getTime();
        //Calendar.getInstance() called a second time
        this.licenceNumber = new LicenceNumber(name.getInitials(), CALENDAR.get(Calendar.YEAR));
        this.licenseStatus = licenseStatus;
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
        return dob;
    }

    /**
     * Returns the status of the licence.
     * @return True if licence is a full licence, false if not.
     */
    public boolean isFullLicense() {
        return licenseStatus;
    }

    /**
     * Returns the date the licence was issued.
     * @return A Date
     */
    public Date getIssueDate() {
        return this.issueDate;
    }

    /**
     * Returns the licence number
     * @return A LicenceNumber
     */
    public LicenceNumber getLicenceNumber() {
        return this.licenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrivingLicence that = (DrivingLicence) o;

        if (!name.equals(that.name)) return false;
        return licenceNumber.equals(that.licenceNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + licenceNumber.hashCode();
        return result;
    }

}
