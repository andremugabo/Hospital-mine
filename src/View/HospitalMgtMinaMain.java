
package View;

import java.util.*;
import Model.*;
import DAO.*;
import java.sql.ResultSet;

/**
 *
 * @author A.M
 */
public class HospitalMgtMinaMain {
    public static void main(String[] args) {
        Boolean condition = true;
        String patientNames ;
        String newName;
        Patient pt = new Patient();
        PatientDao ptd = new PatientDao();
        String feedBack ;
        Scanner sc = new Scanner(System.in);
        int choice;
        String answer;
        
        while(condition){
            System.out.println("===============================");
            
            System.out.println("1. Create Patient ");   
            System.out.println("2. Update Patient ");
            System.out.println("3. Delete Patient ");
            System.out.println("4. Retreive all Patient ");
            System.out.println("5. Create Patient using Prepare Statement ");
            System.out.println("0. For exit ");
            
            System.out.println("Enter your Choice :");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Patient Name:");
                    patientNames = sc.next();
                    
                    if( patientNames.length() >= 3){
                            pt.setPatientNames(patientNames);
                            feedBack = ptd.insertPatient(pt);                    
                            System.out.println(feedBack);
                    }else{
                        System.out.println("Too Short to be a Name");
                    }       
                    System.out.println("Enter Yes or No if you wish to proced or exit !!:");
                    
                    answer = sc.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank for using the system !!");
                        condition =false;
                    }
                     break;
                 case 2:
                     System.out.println("Enter the Patient Name to Update");
                     patientNames = sc.next();
                     pt.setPatientNames(patientNames);
                     System.out.println("Enter the new Name :");
                     newName = sc.next();
                     pt = new Patient();// verry important remove the previews data
                     pt.setNewName(newName);
                     feedBack = ptd.updatePetientPrepare(pt,pt);
                     System.out.println(feedBack);
                     System.out.println("Enter Yes or No to Continue or to Quit");
                     answer = sc.next();
                     if(answer.equalsIgnoreCase("yes")){
                         condition = true;
                     }else{
                         System.out.println("Thank you for using the System");
                         condition = false;
                     }
                    break;
                case 3:
                    System.out.println("Enter the Patient name to be Deleted :");
                    patientNames = sc.next();
                    pt.setPatientNames(patientNames);
                    ptd = new PatientDao();
                    feedBack = ptd.deletePatientPrepare(pt);
                    System.out.println(feedBack);
                    
                    System.out.println("Enter Yes or No to Continue or to Quit");
                     answer = sc.next();
                     if(answer.equalsIgnoreCase("yes")){
                         condition = true;
                     }else{
                         System.out.println("Thank you for using the System");
                         condition = false;
                     }
                    
                    break;
                case 4:
                    System.out.println("============================================");
                    System.out.println("==============Recorded Patient==============");
                    ResultSet result = ptd.selectAllPatient();
                    try{
                        while(result.next()){
                            System.out.println("Patient ID: "+result.getInt("patient_id") +" Patient Name: "+result.getString("patient_names"));
                        }
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    
                    System.out.println("Enter Yes or No to Continue or to Quit");
                     answer = sc.next();
                     if(answer.equalsIgnoreCase("yes")){
                         condition = true;
                     }else{
                         System.out.println("Thank you for using the System");
                         condition = false;
                     }
                    break;
                case 5:
                    System.out.println("Enter Patient name :");
                    patientNames = sc.next();
                    pt.setPatientNames(patientNames);
                    feedBack = ptd.insertPatientPrepare(pt);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes or No to Continue or to Quit");
                    answer = sc.next();
                    if(answer.equalsIgnoreCase("Yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    
                    break;    
                   
                case 0:
                    System.exit(0);
                    break;
            }
            



        }
        
        
        
        
        
        
        
    }
}
