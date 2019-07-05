// OsInfo
package com.dsite.serverstatus.sysinfo;

import java.util.HashMap;
import java.io.Serializable;

import com.dsite.serverstatus.utils.UtilsFile;

// This information is from ubuntu (/etc/lsb-release)
// val:
//      DISTRIB_ID=Ubuntu
//      DISTRIB_RELEASE=18.04
//      DISTRIB_CODENAME=bionic
//      DISTRIB_DESCRIPTION="Ubuntu 18.04.2 LTS"
//

public class OsInfo implements Serializable {

    private static final String KEY_ID       = "DISTRIB_ID";
    private static final String KEY_RELEASE  = "DISTRIB_RELEASE";
    private static final String KEY_CODENAME = "DISTRIB_CODENAME";
    private static final String KEY_DESC     = "DISTRIB_DESCRIPTION";

    private String id;
    private String release;
    private String codename;
    private String description;

    // Init
    public OsInfo(String val) {
        String[] steps = this.splitStep(val);
        for (String step : steps) {
            String[] kv = this.splitKeyVal(step);
            System.out.println(kv[0]);
            System.out.println(kv[1]);
            this.setInfo(kv);
        }
    }

    private void setInfo(String[] kv) {
        if      (kv[0].equals(this.KEY_ID))         {this.id = kv[1];}
        else if (kv[0].equals(this.KEY_RELEASE))    {this.release = kv[1];}
        else if (kv[0].equals(this.KEY_CODENAME))   {this.codename = kv[1];}
        else if (kv[0].equals(this.KEY_DESC))       {this.description = kv[1];}
    }

    private String[] splitStep(String data) {
        String[] ret = data.split("\n");
        return ret;
    }

    private String[] splitKeyVal(String data) {
        String[] ret = data.split("=");
        return ret;
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public String getId()           {return this.id;}
    public String getRelease()      {return this.release;}
    public String getCodeName()     {return this.codename;}
    public String getDescription()  {return this.description;}
}

