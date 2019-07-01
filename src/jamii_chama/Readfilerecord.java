package jamii_chama;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
 /* @author ENG. KEVOH
 */
public class Readfilerecord {
    public static String[] readArrayfirstname(String fname){
            int ctr = 0;
            try{
                Scanner firname = new Scanner(new File(fname));
                while(firname.hasNext()){
                    ctr = ctr+1;
                    firname.next();
                }
                String[] words = new String[ctr];
                Scanner firstName = new Scanner(new File(fname));
                for (int i =0; i < ctr; i++){
                    words[i] = firstName.next();
                }
                return words;
            }catch(Exception e){}
            return null;
        }
    
        public static String[] readArraySecname(String sname){
            int ctr = 0;
            try{
                Scanner secName = new Scanner(new File(sname));
                while(secName.hasNext()){
                    ctr = ctr+1;
                    secName.next();
                }
                String[] secondName = new String[ctr];
                Scanner secoName = new Scanner(new File(sname));
                for (int i =0; i < ctr; i++){
                    secondName [i] = secoName.next();
                }
                return secondName;
            }catch(Exception e){}
            return null;
        }
        
            public static String[] readArraylstname(String lname){
            int ctr = 0;
            try{
                Scanner lstname = new Scanner(new File(lname));
                while(lstname.hasNext()){
                    ctr = ctr+1;
                    lstname.next();
                }
                String[] lastName = new String[ctr];
                Scanner laName = new Scanner(new File(lname));
                for (int i =0; i < ctr; i++){
                    lastName[i] = laName.next();
                }
                return lastName;
            }catch(Exception e){}
            return null;
        }
            
                public static String[] readArray(String membertype){
            int ctr = 0;
            try{
                Scanner membertyp = new Scanner(new File(membertype));
                while(membertyp.hasNext()){
                    ctr = ctr+1;
                    membertyp.next();
                }
                String[] membership = new String[ctr];
                Scanner membershp = new Scanner(new File(membertype));
                for (int i =0; i < ctr; i++){
                    membership[i] = membershp.next();
                }
                return membership;
            }catch(Exception e){}
            return null;
        }
                
                    public static String[] readArrayamount(String amount){
                        int ctr = 0;
                        try{
                        Scanner capital = new Scanner(new File(amount));
                        while(capital.hasNext()){
                            ctr = ctr+1;
                            capital.next();
                        }
                        String[] accumulatedAmount = new String[ctr];
                        Scanner accAmount = new Scanner(new File(amount));
                        for (int i =0; i < ctr; i++){
                            accumulatedAmount[i] = accAmount.next();
                        }
                        return accumulatedAmount;
                        }catch(Exception e){}
                        return null;
        }
                    
              
    
}
