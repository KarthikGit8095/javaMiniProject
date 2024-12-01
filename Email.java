package emailApp;

import java.util.Scanner;

public class Email {
    //encapsulating these variable so that no one can change or access this variable
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength=8;
    private String alternateEmail;
    private String companySuffix="mathrushree.com";

    //constructor to receive the first and last name
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

        //call the method asking for a department and return the department
        this.department=setDepartment();

        //cassl a method that return a random password
        this.password=ranPassword(defaultPasswordLength);
        System.out.println("your password is "+this.password);

        //combine elements to generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
    }

    //ask for the department

    private String setDepartment(){
        System.out.println("NEW WORKER: "+firstName+"\nDepartment CODE \n1 for Sales\n2 Development\n3 Accounting\n0 None\nEnter department code: ");
        Scanner sc=new Scanner(System.in);
        int depChoice=sc.nextInt();
        if(depChoice==1){
            return "Sales";
        } else if (depChoice==2) {
            return "Development";
        } else if (depChoice==3) {
            return "Accounting";
        }
        else{
            return "none";
        }
    }

    //generate a random password
    private String ranPassword(int length){
        String passwordset="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password=new char[length];
        for(int i=0;i<length;i++){
            int rand= (int)(Math.random() * passwordset.length());
            password[i]=passwordset.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;

    }

    //set the alternate email
    public void setAlternateEmail(String altemail){
        this.alternateEmail=altemail;
    }

    //change the password
    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+"\n"+
                "COMPANY EMAIL: "+email+"\n"+
                "MAILBOX CAPACITY: "+mailboxCapacity+"mb";

    }



}
