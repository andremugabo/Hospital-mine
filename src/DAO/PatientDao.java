
package DAO;
import java.util.*;
import java.sql.*;
import Model.Patient ;


/**
 *
 * @author A.M
 */
public class PatientDao {
     private String dbUlr = "jdbc:mysql://localhost:3306/thursday_db";
     private String username = "root";
     private String password = "";

    public PatientDao() {
    }
     
    public String insertPatient(Patient patientObj){
        
        try{
            Connection con = DriverManager.getConnection(dbUlr, username, password);
            String query = "insert into patient(patient_names) values('"+patientObj.getPatientNames()+"')";
            Statement st = con.createStatement();
            int rowAffected = st.executeUpdate(query);
            con.close();
            if(rowAffected>=1){
                return "Patient saved successfully";
            }else{
                return "Process Failed ";
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return"Server error";
        }
        
    } 
    
    public String insertPatientPrepare(Patient patientObj){
        try{
               Connection con = DriverManager.getConnection(dbUlr, username, password);
               String query = "insert into patient(patient_names) values(?)";
               PreparedStatement pst = con.prepareStatement(query);
               pst.setString(1, patientObj.getPatientNames());
               int rowAffected = pst.executeUpdate();
               con.close();
               if(rowAffected >=1){
                   return "Data Saved !!";
               }else{
                   return "Data Not Saved !!";
               }
        }catch(Exception ex){
            ex.printStackTrace();
            return "Server Error !!";
        }
        
    }
     
    public String updatePetientPrepare(Patient patientObj,Patient ToUpdateObj){
        try{
        Connection con = DriverManager.getConnection(dbUlr, username, password);
        String query = "UPDATE patient SET patient_names = ? WHERE patient_names = ? ";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, patientObj.getNewName());
        pst.setString(2,ToUpdateObj.getPatientNames());
        int rowAffected = pst.executeUpdate();
        
        if(rowAffected >= 1){
            return "Patient names Updated";
        }else{
            return "Update Failed";
        }
        
        }catch(Exception ex){
            ex.printStackTrace();
            return "Server Error";
        }
    }
    
    public String deletePatientPrepare(Patient patientObj){
        try{
        Connection con = DriverManager.getConnection(dbUlr, username, password);
        String query = "DELETE FROM patient WHERE patient_names = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,patientObj.getPatientNames());
        int rowAffected = pst.executeUpdate();
        con.close();
                if(rowAffected >= 1){
                  return "Patient deleted";
                }else{
                    return "Failed";
                }
        
        }catch(Exception ex){
            ex.printStackTrace();
            return"Serever Error";
        }
    }
    
    public ResultSet selectAllPatient(){
        try{
            ResultSet result = null;
            Connection con = DriverManager.getConnection(dbUlr, username, password);
            String query = "SELECT * FROM patient";
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
            
            if(result != null){                    
                       return result;                   
            }else{
              return null;
            }
           
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
    }
    
    public List<Patient> allPatient(){
        try {
            Connection con = DriverManager.getConnection(dbUlr, username, password);
            String query = "select * from patient";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            //collection
            List<Patient> patientList = new ArrayList<>();
            while(result.next()){
            Patient pt = new Patient();
//            pt.
            
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Patient searchPatient(Patient patientObj){
        try {
            Connection con = DriverManager.getConnection(dbUlr, username, password);
            String query = "select * from patient";
            PreparedStatement pst = con.prepareStatement(query);
            pst.set
            ResultSet result = pst.executeQuery();
            
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    
    
    
    
    
}
