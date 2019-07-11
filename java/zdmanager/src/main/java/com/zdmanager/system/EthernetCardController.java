// EthernetCardController
package com.zdmanager.system;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdmanager.system.EthernetCard;
import com.zdmanager.utils.UtilsExecCmd;

@Controller
@RequestMapping("/rest/ethernets")
public class EthernetCardController {

    private static final String[] CMD_LSPCI = {
        "/bin/sh",
        "-c",
        "lspci | grep Ethernet"
    };
    private EthernetCard eths;

    public EthernetCardController() {
        this.eths = this.getEths();
    }

    private EthernetCard getEths() {
        UtilsExecCmd uec = new UtilsExecCmd();
        String data = uec.exec(this.CMD_LSPCI);
        return new EthernetCard(data);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody EthernetCard get(HttpServletResponse res) {
        return this.eths;
    }
}
