package com.dsite.serverstatus.sysinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysInfoController {

	@RequestMapping(value="/sysinfo", method=RequestMethod.GET)
	public void sysinfo() {
	}

}
