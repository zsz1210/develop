// UtilsExecCmd
package com.zdmanager.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilsExecCmd {

    // Init
    static void UtilsExecCmd() {
    }

    private String __exec(String[] cmd) {
        String res  = "";
        String line = "";
        try {
            Process p   = Runtime.getRuntime().exec(cmd);
            int result  = p.waitFor();
            InputStreamReader inStream = new InputStreamReader(p.getInputStream());
            BufferedReader reader = new BufferedReader(inStream);
            while ((line = reader.readLine()) != null) {
                res += line;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public String exec(String[] cmd) {return this.__exec(cmd);}

}
