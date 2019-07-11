// CpuInfo

package com.zdmanager.system;

import java.io.Serializable;

// This information is from ubuntu (cmd: lscpu)
// val:
// Architecture:        x86_64
// CPU op-mode(s):      32-bit, 64-bit
// Byte Order:          Little Endian
// CPU(s):              1
// On-line CPU(s) list: 0                               *Ignore
// Thread(s) per core:  1
// Core(s) per socket:  1                               *Ignore
// Socket(s):           1                               *Ignore
// NUMA node(s):        1                               *Ignore
// Vendor ID:           GenuineIntel
// CPU family:          6
// Model:               79                              *Ignore
// Model name:          Intel(R) Xeon(R) CPU @ 2.20GHz
// Stepping:            0                               *Ignore
// CPU MHz:             2200.000
// BogoMIPS:            4400.00                         *Ignore
// Hypervisor vendor:   KVM                             *Ignore
// Virtualization type: full
// L1d cache:           32K
// L1i cache:           32K
// L2 cache:            256K
// L3 cache:            56320K
// NUMA node0 CPU(s):   0                               *Ignore
// Flags: ...                                           *Ignore

public class CpuInfo implements Serializable {

    private static final String ARCH       = "Architecture";
    private static final String OPMODE     = "CPU op-mode(s)";
    private static final String BYTEORDER  = "Byte Order";
    private static final String CPUS       = "CPU(s)";
    private static final String THREAD     = "Thread(s) per core";
    private static final String VENDORID   = "Vendor ID";
    private static final String FAMILY     = "CPU family";
    private static final String MODELNAME  = "Model name";
    private static final String MHZ        = "CPU MHz";
    private static final String VIRTYPE    = "Virtualization type";
    private static final String L1DCACHE   = "L1d cache";
    private static final String L1ICACHE   = "L1i cache";
    private static final String L2CACHE    = "L2 cache";
    private static final String L3CACHE    = "L3 cache";

    private String arch;
    private String opmode;
    private String byteorder;
    private String cpus;
    private String thread;
    private String vendorid;
    private String family;
    private String modelname;
    private String mhz;
    private String virtype;
    private String l1dcache;
    private String l1icache;
    private String l2cache;
    private String l3cache;

    public CpuInfo(String val) {
        String[] steps = this.splitStep(val);
        for (String step : steps) {
            String[] kv = this.splitKeyVal(step);
            this.setCpuInfo(kv);
        }
    }

    private void setCpuInfo(String[] kv) {
        if      (kv[0].equals(this.ARCH))        {this.arch      = kv[1].trim();}
        else if (kv[0].equals(this.OPMODE))      {this.opmode    = kv[1].trim();}
        else if (kv[0].equals(this.BYTEORDER))   {this.byteorder = kv[1].trim();}
        else if (kv[0].equals(this.CPUS))        {this.cpus      = kv[1].trim();}
        else if (kv[0].equals(this.THREAD))      {this.thread    = kv[1].trim();}
        else if (kv[0].equals(this.VENDORID))    {this.vendorid  = kv[1].trim();}
        else if (kv[0].equals(this.FAMILY))      {this.family    = kv[1].trim();}
        else if (kv[0].equals(this.MODELNAME))   {this.modelname = kv[1].trim();}
        else if (kv[0].equals(this.MHZ))         {this.mhz       = kv[1].trim();}
        else if (kv[0].equals(this.VIRTYPE))     {this.virtype   = kv[1].trim();}
        else if (kv[0].equals(this.L1DCACHE))    {this.l1dcache  = kv[1].trim();}
        else if (kv[0].equals(this.L1ICACHE))    {this.l1icache  = kv[1].trim();}
        else if (kv[0].equals(this.L2CACHE))     {this.l2cache   = kv[1].trim();}
        else if (kv[0].equals(this.L3CACHE))     {this.l3cache   = kv[1].trim();}
    }

    private String[] splitStep(String data) {
        String[] ret = data.split("\n");
        return ret;
    }

    private String[] splitKeyVal(String data) {
        String[] ret = data.split(":");
        return ret;
    }

    ////////////////////////////////////////////////////////////////
    // public method
    public String getArch()       {return this.arch;}
    public String getOpmode()     {return this.opmode;}
    public String getByteOrder()  {return this.byteorder;}
    public String getCpus()       {return this.cpus;}
    public String getThread()     {return this.thread;}
    public String getVendorId()   {return this.vendorid;}
    public String getFamily()     {return this.family;}
    public String getModelName()  {return this.modelname;}
    public String getMhz()        {return this.mhz;}
    public String getVirType()    {return this.virtype;}
    public String getL1dCache()   {return this.l1dcache;}
    public String getL1iCache()   {return this.l1icache;}
    public String getL2Cache()    {return this.l2cache;}
    public String getL3Cache()    {return this.l3cache;}
}
