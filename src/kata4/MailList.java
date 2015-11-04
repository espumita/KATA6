package kata4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailList {
    public static ArrayList<String> read(String fileName) throws FileNotFoundException, IOException{
        ArrayList<String> mailList = new ArrayList<>();
        BufferedReader fileMail = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while ((mail=fileMail.readLine()) != null) {            
            if(!mail.contains("@")) continue;
            mailList.add(mail);
        }
        return mailList;
    }
}
