package com.dsite.serverstatus.sysinfo;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsite.serverstatus.sysinfo.OsInfo;
import com.dsite.serverstatus.utils.UtilsFile;

@Controller
@RequestMapping("/sysinfo")
public class SysInfoController {

    private static final String UBUNTU_OSINFO_PATH = "/etc/lsb-release";
    private OsInfo oif;

    public SysInfoController() {
        this.oif = this.getOsInfo();
        System.out.println(this.oif.getId());
        System.out.println(this.oif.getCodeName());
        System.out.println(this.oif.getRelease());
        System.out.println(this.oif.getDescription());
	}

    private OsInfo getOsInfo() {
        UtilsFile uf = new UtilsFile();
        String data = uf.readFile(this.UBUNTU_OSINFO_PATH);
        return new OsInfo(data);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody OsInfo get(HttpServletResponse res) {
        return this.oif;
    }
}
