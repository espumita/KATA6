package kata4;

import java.io.File;

public class KATA4 {
    
    public static void main(String[] args) {
        String fileName = "C:\\Users\\usuario\\Documents";
        File file = new File(fileName);
        String[] filesArray = file.list();
        for (String files : filesArray) {
            //System.out.println(files);
        }
        print(file.listFiles(),"");
    }

    private static void print(File[] listFiles, String ident) {
        if (listFiles == null ) return;
        for (File listFile : listFiles) {
            System.out.println(ident+(listFile.isDirectory()? "+" : "  " )+listFile.getName());
            if(!listFile.isDirectory() || listFile.isHidden()) continue;
            print(listFile.listFiles(),ident+" ");
        }
    }
}
