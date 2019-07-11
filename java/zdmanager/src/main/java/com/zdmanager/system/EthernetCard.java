// EthernetCard

package com.zdmanager.system;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.zdmanager.utils.UtilsExecCmd;

// This information is from ubuntu (cmd: lspci | grep Ethernet)
// val:
//      00:04.0 Ethernet controller: Red Hat, Inc. Virtio network device
//
//

public class EthernetCard implements Serializable {
   
    private static final String ETHERNET  = "Ethernet";

    private List<String> eths;

    // Init
    public EthernetCard(String val) {
        eths = new ArrayList<String>();
        String[] steps = this.splitStep(val);
        for (String step : steps) {
            System.out.println("STEPS"+step);
            String[] eth = this.splitEth(step);
            this.setEth(eth);
        }
    }

    private void setEth(String[] eth) {
        if (eth[1].contains(this.ETHERNET)) {
            this.eths.add(eth[2]);
        }
    }

    private String[] splitEth(String data) {
        String[] ret = data.split(":");
        return ret;
    }

    private String[] splitStep(String data) {
        String[] ret = data.split("\n");
        return ret;
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public List<String> getEthernets()  {return this.eths;}
}
