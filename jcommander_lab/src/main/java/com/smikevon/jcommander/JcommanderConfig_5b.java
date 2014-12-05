package com.smikevon.jcommander;

import com.beust.jcommander.Parameter;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午9:17
 */
public class JcommanderConfig_5b {

    @Parameter(names="-slave")
    private String slave;

    @Override
    public String toString() {
        return "JcommanderConfig_5b{" +
                "slave='" + slave + '\'' +
                '}';
    }
}
