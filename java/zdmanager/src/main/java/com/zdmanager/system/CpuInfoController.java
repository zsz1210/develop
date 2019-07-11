// CpuInfoController
package com.zdmanager.system;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdmanager.system.CpuInfo;
import com.zdmanager.utils.UtilsExecCmd;

@Controller
@RequestMapping("/rest/cpuinfo")
public class CpuInfoController {

    private static final String[] CMD_LSCPU = {
        "/bin/sh",
        "-c",
        "lscpu"
    };

    private CpuInfo cpuinfo;

    public CpuInfoController() {
        this.cpuinfo = this.getCpuInfo();
    }

    private CpuInfo getCpuInfo() {
        UtilsExecCmd uec = new UtilsExecCmd();
        String data = uec.exec(this.CMD_LSCPU);
        System.out.println(data);
        return new CpuInfo(data);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody CpuInfo get(HttpServletResponse res) {
        return this.cpuinfo;
    }
}

