package org.mindgentrix.web.composers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Messagebox;
 
public class ApprovalComposer {
 
 private List<person> allPersons = new ArrayList<person>();
  private person selectedPerson;
  private List<person> selectedPersons;
  
    public person getSelectedPerson() {
     return selectedPerson;
  }
 
   public void setSelectedPerson(person selectedPerson) {
      this.selectedPerson = selectedPerson;
   }
 
   public List<person> getSelectedPersons() {
        return selectedPersons;
 }
 
   public void setSelectedPersons(List<person> selectedPersons) {
        this.selectedPersons = selectedPersons;
 }
 
   public List<person> getAllPersons() {
     return allPersons;
  }
 
   public void setAllPersons(List<person> allPersons) {
      this.allPersons = allPersons;
   }
 
   public ApprovalComposer() {
 
     allPersons.add(new person("John", "James", "JohnJames@yahoo.com"));
     allPersons.add(new person("Taylor", "Harris", "Harris@yahoo.com"));
     allPersons.add(new person("Allen", "Scott", "Scott@yahoo.com"));
 
    }
    
    @Command
    public void onShowEmailID()
 {
       String emailIDs="";
      
        if (this.selectedPersons==null)
     {
           Messagebox.show(" No Items selected");
          return;
     }
 
       if (this.selectedPersons.size()==0)
     {
           Messagebox.show(" No Items selected");
          return;
     }
 
       for (Iterator<person> i = selectedPersons.iterator(); i
               .hasNext();) {
          person tmp = i.next();
          emailIDs = emailIDs.concat(tmp.getEmail()).concat(";");
     }
        
        Messagebox.show("Selected Emails are " + emailIDs);
 }
 
   // inner class
  public class person {
       private String firstName;
       private String lastName;
        private String email;
 
       public person(String firstName, String lastName, String email) {
            this.firstName = firstName;
         this.lastName = lastName;
           this.email = email;
     }
 
       public String getFirstName() {
          return firstName;
       }
 
       public void setFirstName(String firstName) {
            this.firstName = firstName;
     }
 
       public String getLastName() {
           return lastName;
        }
 
       public void setLastName(String lastName) {
          this.lastName = lastName;
       }
 
       public String getEmail() {
          return email;
       }
 
       public void setEmail(String email) {
            this.email = email;
     }
 
   }
}


