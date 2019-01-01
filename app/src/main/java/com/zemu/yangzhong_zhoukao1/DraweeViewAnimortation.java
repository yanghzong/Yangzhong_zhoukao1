package com.zemu.yangzhong_zhoukao1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 择木 on 2018/12/3.
 */
//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)


public @interface DraweeViewAnimortation {
    String name();
}
