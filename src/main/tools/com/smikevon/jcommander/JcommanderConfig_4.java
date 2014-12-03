package com.smikevon.jcommander;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午8:34
 */
@Parameters(separators = ":")
public class JcommanderConfig_4 {

    @Parameter(names = "-host",description = "The host")
    public List<String> hosts = new ArrayList<String>();

    @Parameter(names = {"-log","-verbose"},description = "Level of verbosity")
    public Integer verbose = 1;

    @Parameter(names = "-groups",description = "Comma-separated list of group names to be run")
    public String groups;

    @Parameter(names = "-debug",description = "Debug mode")
    public boolean debug = true;

    @Parameter(names = "-password",description = "Connection password",password = true,echoInput = true)
    public String password;

    @Override
    public String toString() {
        return "JcommanderConfig_4{" +
                "hosts=" + hosts +
                ", verbose=" + verbose +
                ", groups='" + groups + '\'' +
                ", debug=" + debug +
                ", password='" + password + '\'' +
                '}';
    }
}
