package jamii_chama;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Writerecordfile {
	public void writeTofile(String name1, String name2, String name3,
                String membertyp, String amount) {
		try {

			String firname = name1;
                        String secname = name2;
                        String lstname = name3;
                        String memberspecify = membertyp;
                        String currentamount = amount;

			File firstname = new File("firstname.txt");
                        File scondname = new File("secondname.txt");
                        File lastname = new File("lastname.txt");
                        File membership = new File("membership.txt");
                        File capital = new File("amount.txt");

			// if file doesnt exists, then create it
			if (!firstname.exists()) {
				firstname.createNewFile();
			}else if(!scondname.exists()){
                            scondname.createNewFile();
                        }
                        else if(!lastname.exists()){
                            lastname.createNewFile();
                        }
                        else if(!membership.exists()){
                            membership.createNewFile();
                        }else if(!capital.exists()){
                            capital.createNewFile();
                        }



			FileWriter first = new FileWriter(firstname.getAbsoluteFile(), true);
                        FileWriter second = new FileWriter(scondname.getAbsoluteFile(), true);
                        FileWriter last = new FileWriter(lastname.getAbsoluteFile(), true);
                        FileWriter membertype = new FileWriter(membership.getAbsoluteFile(), true);
                        FileWriter accumulated = new FileWriter(capital.getAbsoluteFile(), true);
                        
			BufferedWriter fname = new BufferedWriter(first);
			fname.write(firname);
                        fname.newLine();
                        fname.newLine();
			fname.close();
                        BufferedWriter sname = new BufferedWriter(second);
                        sname.write(secname);
                        sname.newLine();
                        sname.newLine();
			sname.close();
                        BufferedWriter third = new BufferedWriter(last);
                        third.write(lstname);
                        third.newLine();
                        third.newLine();
			third.close();
                        BufferedWriter member = new BufferedWriter(membertype);
                        member.write(memberspecify);
                        member.newLine();
                        member.newLine();
			member.close();
                        
                        BufferedWriter contribution = new BufferedWriter(accumulated);
                        contribution.write(currentamount);
                        contribution.newLine();
                        contribution.newLine();
			contribution.close();

			System.out.println("Done");
                        JOptionPane.showMessageDialog(null, "DATA SUCCESSFULLY RECORDED");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

