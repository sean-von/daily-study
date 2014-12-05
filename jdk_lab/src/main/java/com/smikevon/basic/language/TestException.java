package com.smikevon.basic.language;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-12-3 下午9:47
 */
public class TestException {

    /**
     * 这个是推荐做法
     * @param array
     * @param size
     */
    public void testOne(int[] array,int size){
        throw new IndexOutOfBoundsException("越界异常");
    }

    /**
     * @param array
     * @param size
     * @throws IndexOutOfBoundsException
     */
    public void testTwo(int[] array,int size) throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException("越界异常");
    }
}
