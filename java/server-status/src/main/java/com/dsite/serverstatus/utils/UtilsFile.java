// Common utils
package com.dsite.serverstatus.utils;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UtilsFile {

    // Init
    static void UtilsFile() {
    }

    // check file exist
    private Boolean __exists(String path) {
        File fd = new File(path);
        return fd.exists();
    }

    // read file by one time
    private String __oread(String path) {
        String ret = new String();
        try {
            File fd = new File(path);
            FileInputStream fis = new FileInputStream(fd);
            byte[] data = new byte[(int) fd.length()];
            fis.read(data);
            fis.close();
            ret = new String(data, "UTF-8");
        }
        catch (IOException e) {e.printStackTrace();}
        return ret;
    }

    // write file by one time
    private void __owrite(String path, String val, Boolean append) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path, append);
            byte[] str2Bytes = val.getBytes();
            outputStream.write(str2Bytes);
            outputStream.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public Boolean exists(String path)  {return this.__exists(path);}
    public String readFile(String path) {return this.__oread(path);}
    // write file by append
    public void writeFileA(String path, String val) {this.__owrite(path,val,true);}
    // write file by new
    public void writeFileW(String path, String val) {this.__owrite(path,val,false);}

}
