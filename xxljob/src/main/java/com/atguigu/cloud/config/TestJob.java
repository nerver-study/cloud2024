package com.atguigu.cloud.config;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 任务处理类
 *
 * @author 单程车票
 */
@Component
public class TestJob {
    /**
     * 测试任务
     */
    @XxlJob("testHandler")
    public void testHandler() throws Exception {
        // 参数解析
        String param = XxlJobHelper.getJobParam();

        System.out.println("参数是:"+param);
        if(param!=null&&param.equals("aaa")){
            throw new Exception("测试报错");
        }
        System.out.println("当前时间是:"+new Date()+"\t定时任务执行准备");
        XxlJobHelper.handleSuccess("本次测试任务调度成功");
        System.out.println("当前时间是:"+new Date()+"\t定时任务执行结束");
    }
}