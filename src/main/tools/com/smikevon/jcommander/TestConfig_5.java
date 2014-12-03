package com.smikevon.jcommander;

import com.beust.jcommander.JCommander;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午8:39
 */
public class TestConfig_5 {

    public static void main(String[] args){
        JcommanderConfig_5a config_a = new JcommanderConfig_5a();
        JcommanderConfig_5b config_b = new JcommanderConfig_5b();
        System.out.println(config_a.toString()+"\n"+config_b.toString());
        String[] _args = {"-master","10.237.0.123","-slave","127.0.0.1"};
        JCommander jCommander = new JCommander(new Object[]{config_a,config_b},_args);
        System.out.println(config_a.toString()+"\n"+config_b.toString());
    }

}
