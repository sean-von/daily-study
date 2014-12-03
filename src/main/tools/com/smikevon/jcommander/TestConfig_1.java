package com.smikevon.jcommander;

import com.beust.jcommander.JCommander;
import sun.security.krb5.Config;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午8:39
 */
public class TestConfig_1 {

    public static void main(String[] args){
        JcommanderConfig_1 config = new JcommanderConfig_1();
        System.out.println(config.toString());
        String[] _args = {"-log","2","-groups","unit"};
        JCommander jCommander = new JCommander(config,_args);
        System.out.println(config.toString());
    }

}
