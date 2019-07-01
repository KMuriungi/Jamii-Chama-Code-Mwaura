package jamii_chama;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jamii_chama {
    
    private Scanner readinput;
    static int i = 0;
    
    
    public static void main(String[] args) {
       Graphicaluserinterphase graphicobject = new Graphicaluserinterphase();
       graphicobject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       graphicobject.setVisible(true);
       Readfilerecord readobject = new Readfilerecord();
       String[] fname = readobject.readArrayfirstname("firstname.txt");
       String[] sname = readobject.readArrayfirstname("secondname.txt");
       String[] lname = readobject.readArrayfirstname("lastname.txt");
       String[] membataip = readobject.readArrayfirstname("membership.txt");
       String[] amcapital = readobject.readArrayfirstname("amount.txt");
       ArrayList myList = new ArrayList();
        Collections.addAll(myList, fname);
        //deletefile(myList, "kelvin");
    }
     
     
    
}
