package kata6;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        String fileName = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\KATA6\\data\\emails.txt";
        ArrayList<Person> listMail = MailList.read(fileName);
        
        ArrayList<Person1> perso = PersonLoader.read();
        
        
        
        //Histogram<String> histogram = MailHistogramBuilder.build(listMail);
        HistogramBuilder<Person> builder1 = new HistogramBuilder<>(listMail);
        
        HistogramBuilder<Person1> builder2 = new HistogramBuilder<>(perso);
        
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
        
        
        Histogram<String> domains1 = builder2.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> pesos = builder2.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        Histogram<Character> genero = builder2.build(new Attribute<Person1, Character>() {

            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        
        
        //new HistogramDisplay(domains,"DOMINIOS").execute();
        //new HistogramDisplay(letters,"CARACTER").execute();
        
        new HistogramDisplay(domains1,"DOMINIOS").execute();
        new HistogramDisplay(pesos,"PESOS").execute();
        new HistogramDisplay(genero,"GENERO").execute();

        //HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        //histogramDisplay.execute();


    }
    
}
