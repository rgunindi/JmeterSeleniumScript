package Odev1.utilities;

import Odev1.pageObjects.KampanyaPage;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BufferedWriteFile {
    BufferedWriter outFile;
    public BufferedWriteFile(){
        try{ outFile= Files.newBufferedWriter(Path.of("kampanyalar.csv"), StandardCharsets.UTF_8); }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void printToFile() {
        List<String> kampayaAndPromosyonList=KampanyaPage.csvFileContent;

       try{ for (String textUrl:kampayaAndPromosyonList){

                if (outFile!=null){
                    try{  outFile.write(textUrl);outFile.newLine();}catch (Exception ignored){}
                }
            outFile.flush();
        }
        outFile.close();
    }catch (Exception ex){}
    }
}
