
package Model;

/**
 *
 * @author A.M
 */
public class Patient {
 private String patientNames;
 private String NewName;

    public Patient() {
    }

    public Patient(String patientNames, String NewName) {
        this.patientNames = patientNames;
        this.NewName = NewName;
    }

    public String getPatientNames() {
        return patientNames;
    }

    public String getNewName() {
        return NewName;
    }

    public void setPatientNames(String patientNames) {
        this.patientNames = patientNames;
    }

    public void setNewName(String NewName) {
        this.NewName = NewName;
    }

   
 
}
