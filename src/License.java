import java.util.Date;

/**
 * Created by Cree on 27/02/2017.
 */
public class License {
    private Name name;
    private Date dob;
    private LicenseNumber licenseNumber;
    private boolean licenseStatus;

    public License(Name name, Date date){

    }

    public Name getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dob;
    }

}
