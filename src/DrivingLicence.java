import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cree on 24/02/2017.
 */
public class DrivingLicence {
    private Name name;
    private Date dob;
    private Date issueDate;
    private LicenceNumber licenceNumber;
    private boolean licenseStatus;

    public DrivingLicence(Name name, Date date, boolean licenseStatus){
        this.name = name;
        this.dob = date;
        this.issueDate = Calendar.getInstance().getTime();
        this.licenceNumber = new LicenceNumber(name.getInitials(), Calendar.getInstance().get(Calendar.YEAR));
        this.licenseStatus = licenseStatus;
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
