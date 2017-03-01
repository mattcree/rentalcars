import java.util.Date;

/**
 * Created by Cree on 24/02/2017.
 */
public class DrivingLicense {
    private Name name;
    private Date dob;
    private Date issueDate;
    private LicenseNumber licenseNumber;
    private boolean licenseStatus;

    public License(Name name, Date date, Date issueDate){
        this.name = name;
        this.dob = date;
        this.issueDate = issueDate;
        this.licenseNumber = new LicenseNumber(name.getInitials(), issueDate.getYear());
    }

    public Name getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public boolean isFullLicense() {
        return licenseStatus;
    }
}
