package com.dsite.serverstatus.sysinfo;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.GetMapping;

import com.dsite.serverstatus.sysinfo.OsInfo;
import com.dsite.serverstatus.utils.UtilsFile;

@Controller
@RequestMapping("/osinfo")
public class OsInfoController {

    private static final String UBUNTU_OSINFO_PATH = "/etc/lsb-release";
    private OsInfo oif;

    public OsInfoController() {
        this.oif = this.getOsInfo();
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

    @GetMapping("/test")
    public String index() {
      return "/ss";
    }
}
