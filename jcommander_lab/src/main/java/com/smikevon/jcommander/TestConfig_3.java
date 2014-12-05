package com.smikevon.jcommander;

import com.beust.jcommander.JCommander;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午8:39
 */
public class TestConfig_3 {

    public static void main(String[] args){
        JcommanderConfig_3 config = new JcommanderConfig_3();
        System.out.println(config.toString());
        String[] _args = {"-host","127.0.0.1","-groups","unit","-host","localhost"};
        JCommander jCommander = new JCommander(config,_args);
        System.out.println(config.toString());
    }

}
