package com.smikevon.jcommander;

import com.beust.jcommander.JCommander;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午8:39
 */
public class TestConfig_6 {

    public static void main(String[] args){
        JcommanderConfig_6 config = new JcommanderConfig_6();
        System.out.println(config.toString());
        String[] _args = {"-host","127.0.0.1","localhost","10.237.115.119","-groups","unit"};
        JCommander jCommander = new JCommander(config,_args);
        System.out.println(config.toString());

        jCommander.usage();

    }

}
