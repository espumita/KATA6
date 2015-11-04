package kata4;

import java.io.IOException;
import java.util.ArrayList;

public class KATA4 {
    
    public static void main(String[] args) throws IOException{
        String fileName = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\KATA4\\data\\emails.txt";
        ArrayList<String> listMail = MailList.read(fileName);
        Histogram<String> histogram = MailHistogramBuilder.build(listMail);
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
    
}
