package JVIM.code;
import JVIM.Commend.commend;
import JVIM.JVIM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeLSP {
    static File theLSPfile = new File("");
    static String thePaths = "";
    public static boolean checkisCode(String theCode){
        String[] theLSP = new CodeLSP().getFromFile();
        String[] checkDone=new String[50];
        String doneCode = theCode;
        int num = 0;
        if (theCode.equals("")){
            return false;
        }
        for (int i = 0; i < theLSP.length; i++) {
            if (doneCode.length() < theLSP[i].length()) {
                if (theLSP[i].substring(0, doneCode.length()).equals(doneCode)) {
                    checkDone[num] = theLSP[i];
                    num++;
                }
            }
        }
        String[] function = CheckCode.getfunctionName();
        if (function[0]!=null) {
            for (int i = 0; i < JVIM.nowShowHowString(function); i++) {
                if (doneCode.length() < function[i].length()) {
                    if (function[i].substring(0, doneCode.length()).equals(doneCode)) {
                        checkDone[num] = function[i];
                    }
                }
            }
        }
        if (JVIM.nowShowHowString(checkDone)>0){
            return true;
        }else {
            return false;
        }
    }
    public static String[] getLSP(String theCode){

       String[] theLSP = new CodeLSP().getFromFile();
            String[] checkDone=new String[50];
            String doneCode = theCode;
            int num = 0;
            for (int i = 0; i < theLSP.length; i++) {
                if (doneCode.length() < theLSP[i].length()) {
                    if (theLSP[i].substring(0, doneCode.length()).equals(doneCode)) {
                        checkDone[num] = theLSP[i];
                        num++;
                    }
                }
            }

            String[] function = CheckCode.getfunctionName();
            if (function[0]!=null) {
                for (int i = 0; i < JVIM.nowShowHowString(function); i++) {
                    if (doneCode.length() < function[i].length()) {
                        if (function[i].substring(0, doneCode.length()).equals(doneCode)) {
                            checkDone[num] = function[i];
                        }
                    }
                }
            }
            return checkDone;
        }
    private String[] getFromFile(){
        String text="";
        try {
            FileReader reader = new FileReader(theLSPfile);
            int date;
            while ((date = reader.read()) != -1){
                text+=(char)date;
            }
                    reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return text.split(",");
    }
    public static void setLSPfile(String thepath){
                thePaths = "JVIM/code/LSP/"+thepath+"_LSP";
        theLSPfile = new commend().readFileFromJar(thePaths);
    }
}
