// Uptime

package com.zdmanager.system;

import java.io.Serializable;

import com.zdmanager.utils.UtilsExecCmd;

// This information is from ubuntu (cmd: uptime -p)
// val:
//      up 5 days, 4 hours, 34 minutes
//

public class Uptime implements Serializable {

    private Integer years   = 0;
    private Integer months  = 0;
    private Integer days    = 0;
    private Integer hours   = 0;
    private Integer mins    = 0;
    private Integer secs    = 0;

    public Uptime(Integer uptime) {
        this.setYears(uptime);
        this.setMonths(uptime);
        this.setDays(uptime);
        this.setHours(uptime);
        this.setMins(uptime);
        this.setSecs(uptime);
    }

    private void setYears(Integer secs) {
        this.years = secs / 2678400;
    }

    private void setMonths(Integer secs) {
        this.months = (secs / 2678400) % 12;
    }

    private void setDays(Integer secs) {
        this.days = (secs / 86400) % 31;
    }

    private void setHours(Integer secs) {
        this.hours = (secs / 3600) % 24;
    }

    private void setMins(Integer secs) {
        this.mins = (secs / 60) % 60;
    }

    private void setSecs(Integer secs) {
        this.secs = secs % 60;
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public Integer getYears()   {return this.years;}
    public Integer getMonths()  {return this.months;}
    public Integer getDays()    {return this.days;}
    public Integer getHours()   {return this.hours;}
    public Integer getMins()    {return this.mins;}
    public Integer getSecs()    {return this.secs;}

}
