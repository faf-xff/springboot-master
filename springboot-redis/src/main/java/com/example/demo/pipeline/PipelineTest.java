package com.example.demo.pipeline;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * 路径：com.example.demo.pipeline
 * 类名：
 * 功能：通过pipeline方式进行大批量的操作
 * 备注：
 * 创建人：typ
 * 创建时间：2019/2/15 17:28
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
public class PipelineTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("58.87.110.60", 6370);
        jedis.auth("hcycom123");

        long start = System.currentTimeMillis();
        pipeline(jedis);
        long end = System.currentTimeMillis();
        log.info("pipeline:"+(end - start)+"毫秒");

        //----------------------------------------------------------------

        start = System.currentTimeMillis();
//        notPipeline(jedis);
        end = System.currentTimeMillis();
        log.info("notPipeline:"+(end - start)+"毫秒");
    }

    /**
     * 方法名：
     * 功能：使用pipeline
     * 描述：
     * 创建人：typ
     * 创建时间：2019/2/15 17:31
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void pipeline(Jedis jedis){
        try {
            Pipeline pipeline = jedis.pipelined();
            for (int i = 0; i < 1000; i++) {
                pipeline.get("city:110000");
            }
            pipeline.sync();
            jedis.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 方法名：
     * 功能：未使用pipeline
     * 描述：
     * 创建人：typ
     * 创建时间：2019/2/15 17:31
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void notPipeline(Jedis jedis){
        try {
            for (int i = 0; i < 1000; i++) {
                jedis.get("city:110000");
            }
            jedis.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
