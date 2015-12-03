package kata6;


import java.io.IOException;
import java.util.ArrayList;

public class KATA6 {
    
    public static void main(String[] args) throws IOException{
        String fileName = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\KATA6\\data\\emails.txt";
        ArrayList<Person> listMail = MailList.read(fileName);
        //Histogram<String> histogram = MailHistogramBuilder.build(listMail);
        HistogramBuilder<Person> builder1 = new HistogramBuilder<>(listMail);
        
        Histogram<String> domains = builder1.build(new Attribute<Person,String>() {

             @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder1.build(new Attribute<Person,Character>() {
            
            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters,"CARACTER").execute();

        //HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        //histogramDisplay.execute();


    }
    
}
