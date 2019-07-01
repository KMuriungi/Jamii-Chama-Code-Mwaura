/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamii_chama;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Graphicaluserinterphase extends JFrame implements ActionListener {
    JButton insert, remove, view, next, previous, clear;
    JTextField firstname, secondname, lastname, membership, amountreceived;
    JLabel fname, sname, Lname, membertype, monthlycontribution, amountgiven, existingrecord;
    JLabel currentcontribution, previousrecord, finalrecord, memberserror, contributionserror;
    JLabel managemembers, monitorcontribution;
    static Container container;
    static int i = 0;
    
    public static int increasenidex(){
         i++;
         return i;
     }
     public static int decreasenidex(){
         i--;
         return i;
     }
    
    Graphicaluserinterphase(){
        super("JAMII CHAMA MEMBERS MANAGEMENT AND CONTRIBUTION MONITORING ");
        container = getContentPane();
        container.setLayout(null);
        setBounds(250, 5, 900, 750);
        container.setBackground(Color.WHITE);
        container.setVisible(true);
        
        //Adding JLabels into the container(window)
        managemembers = new JLabel("MEMBERS AND MEMBERSHIP MANAGEMENT");
        managemembers.setBounds(200, 0, 400, 30);
        managemembers.setForeground(Color.RED);
        managemembers.setFont(new Font("courier", Font.BOLD, 15));
        container.add(managemembers);
        
        fname = new JLabel("First Name");
        fname.setBounds(70, 50, 100, 30);
        container.add(fname);
        
        sname = new JLabel("Second Name");
        sname.setBounds(70, 90, 100, 30);
        container.add(sname);
        
        Lname = new JLabel("Last Name");
        Lname.setBounds(70, 130, 100, 30);
        container.add(Lname);
        
        membertype = new JLabel("MEMBERSHIP SPECIFICATION");
        membertype.setBounds(150, 210, 200, 30);
        container.add(membertype);
        
        memberserror = new JLabel("");
        memberserror.setBounds(240, 290, 700, 30);
        memberserror.setForeground(Color.RED);
        memberserror.setVisible(false);
        container.add(memberserror);
        
        existingrecord = new JLabel("Accumulated amount");
        existingrecord.setBounds(500, 100, 200, 30);
        container.add(existingrecord);
        
        monthlycontribution = new JLabel("Legal monthly contribution");
        monthlycontribution.setBounds(500, 130, 200, 30);
        container.add(monthlycontribution);
        
        //Adding textfields into the window.
        firstname = new JTextField();
        firstname.setBounds(170, 50, 180, 30);
        container.add(firstname);
        
        secondname = new JTextField();
        secondname.setBounds(170, 90, 180, 30);
        container.add(secondname);
        
        lastname = new JTextField();
        lastname.setBounds(170, 140, 180, 30);
        container.add(lastname);
        
        membership = new JTextField();
        membership.setBounds(150, 240, 180, 30);
        container.add(membership);
        
        //Adding Buttons into the container
        
        insert = new JButton("INSERT");
        insert.setBounds(250, 350, 100, 30);
        container.add(insert);
        
        remove = new JButton("REMOVE");
        remove.setBounds(350, 350, 100, 30);
        container.add(remove);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450, 350, 100, 30);
        container.add(clear);
        
        previous = new JButton("<< PREVIOUS");
        previous.setBounds(230, 380, 120, 30);
        container.add(previous);
        
        view = new JButton("VIEW");
        view.setBounds(350, 380, 120, 30);
        container.add(view);
        
        next = new JButton("NEXT >>");
        next.setBounds(470, 380, 120, 30);
        container.add(next);
        
        //Adding action listeners to the buttons.
        insert.addActionListener(this);
        remove.addActionListener(this);
        view.addActionListener(this);
        clear.addActionListener(this);
        next.addActionListener(this);
        previous.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event){
        if (event.getSource().equals(view)){
            memberserror.setVisible(false);
            Accessingrecords();
        }
        if (event.getSource().equals(next)){
            memberserror.setVisible(false);
            increasenidex();
            Accessingrecords();
        }
        if (event.getSource().equals(previous)){
            memberserror.setVisible(false);
            decreasenidex();
            Accessingrecords();   
        }
        if (event.getSource().equals(clear)){
                clear();
        }
        if (event.getSource().equals(insert)){
            inputVerification();
           
        }
        if (event.getSource().equals(remove)){
            Deleteverification();
        }
    }
    
     public void inputVerification(){
          String name1 = firstname.getText();
          String name2 = secondname.getText();
          String name3 = lastname.getText();
          String membertyp = membership.getText();
          String amount = firstname.getText();
          if(name1.equals("")|name2.equals("")|name3.equals("")|
                  membertyp.equals("")|amount.equals("")){
                  //JOptionPane.showMessageDialog(null, "please input all the fields!!");
                  memberserror.setVisible(true);
                  memberserror.setText("ERROR : ALL THE FIELDS ARE NEEDED FOR EACH NEW MEMBER ENTRY!!!");
          }else{
                Writerecordfile writeobject = new Writerecordfile();
                 writeobject.writeTofile(name1, name2, name3, membertyp, amount);
                 memberserror.setVisible(true);
                 memberserror.setForeground(Color.GREEN);
                  memberserror.setText("SUCCESS : NEW MEMBER SUCCESSFULLY ADDED INTO THE SYSTEM.");
                  
          }
          
      }
     
          
      public void Deleteverification(){
          String name1 = firstname.getText();
          String name2 = secondname.getText();
          String name3 = lastname.getText();
          String membertyp = membership.getText();
          String amount = firstname.getText();
          if(name1.equals("")|name2.equals("")|name3.equals("")|
                  membertyp.equals("")|amount.equals("")){
                  //JOptionPane.showMessageDialog(null, "please input all the fields!!");
                  memberserror.setVisible(true);
                  memberserror.setForeground(Color.RED);
                  memberserror.setText("ERROR : TO REMOVE A MEMBER FROM THE SYSTEM, SPECIFY ALL THE FIELDS!!!");
          }else{
                 Deletemembersrecord deleteobject = new Deletemembersrecord();
                 Readfilerecord readobject = new Readfilerecord();
                 String[] fname = readobject.readArrayfirstname("firstname.txt");
                 String[] sname = readobject.readArrayfirstname("secondname.txt");
                    String[] lname = readobject.readArrayfirstname("lastname.txt");
                    String[] membataip = readobject.readArrayfirstname("membership.txt");
                 ArrayList firname = new ArrayList();
                 Collections.addAll(firname, fname);
                 
                 ArrayList secname = new ArrayList();
                 Collections.addAll(secname, sname);
                 
                 ArrayList thirname = new ArrayList();
                 Collections.addAll(thirname, lname);
                 
                 ArrayList membertp = new ArrayList();
                 Collections.addAll(membertp, membataip);
                 
                 deleteobject.deletefile(firname, name1, "firstname.txt");
                 deleteobject.deletefile(secname, name2, "secondname.txt");
                 deleteobject.deletefile(thirname, name3, "lastname.txt");
                 deleteobject.deletefile(membertp, membertyp, "membership.txt");
                 JOptionPane.showMessageDialog(null, "RECORD SUCCESSFULLY UPDATED");
                 clear();
                 memberserror.setVisible(true);
                 memberserror.setForeground(Color.GREEN);
                  memberserror.setText("SUCCESS : SPECIFIED MEMBER SUCCESSFULLY DELETED FROM THE SYSTEM.");
                   clear();
          }
      }
      
            public void clear(){
            firstname.setText("");
                  secondname.setText("");
                    lastname.setText("");
                      membership.setText("");
                        memberserror.setVisible(false);
      }
      
      public void Accessingrecords(){
          Readfilerecord readobject = new Readfilerecord();
            String[] fname = readobject.readArrayfirstname("firstname.txt");
                String[] sname = readobject.readArrayfirstname("secondname.txt");
                    String[] lname = readobject.readArrayfirstname("lastname.txt");
                     String[] membataip = readobject.readArrayfirstname("membership.txt");
                         String[] amcapital = readobject.readArrayfirstname("amount.txt");
                                firstname.setText(fname[i]);
                                secondname.setText(sname[i]);
                                lastname.setText(lname[i]);
                                membership.setText(membataip[i]);
            
      }
    
}
