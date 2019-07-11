// Uptime

package com.zdmanager.system;

import java.io.Serializable;

import com.zdmanager.utils.UtilsExecCmd;

// This information is from ubuntu (cmd: uptime -p)
// val:
//      up 5 days, 4 hours, 34 minutes
//

public class Uptime implements Serializable {

    private Integer years = 0;
    private Integer days  = 0;
    private Integer hours = 0;
    private Integer mins  = 0;
    private Integer secs  = 0;

    public Uptime(Integer uptime) {
        this.setDays(uptime);
        this.setHours(uptime);
        this.setMins(uptime);
        this.setSecs(uptime);
    }

    private setDays(Integer secs) {
        this.days = secs / 86400;
    }

    private setHours(Integer secs) {
        this.hours = secs / 3600;
    }

    private setMins(Integer secs) {
    }

    private setSecs(Integer secs) {
    }

}
