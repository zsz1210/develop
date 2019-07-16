// UptimeController
package com.zdmanager.system;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdmanager.system.Uptime;
import com.zdmanager.utils.UtilsExecCmd;

@Controller
@RequestMapping("/rest/uptime")
public class UptimeController {

    private static final String[] PROC_UPTIME = {
        "cat",
        "/proc/uptime"
    };
    private Uptime uptime;

    public UptimeController() {
    }

    private Uptime getUptime() {
        UtilsExecCmd uec = new UtilsExecCmd();
        String data = uec.exec(this.PROC_UPTIME);
        float s = this.splitTime(data);
        int startup = (int)s;
        return new Uptime(startup);
    }

    private float splitTime(String time) {
        String[] s = time.split(" ");
        float f = Float.parseFloat(s[0]);
        return f;
    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Uptime get(HttpServletResponse res) {
        this.uptime = this.getUptime();
        return this.uptime;
    }
}

