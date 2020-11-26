package com.example.demo.controller;

import com.example.demo.entity.RedisModel;
import com.example.demo.service.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路径：com.example.demo.controller
 * 类名：TestController
 * 功能：springboot+redis
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/15 22:18
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
@RequestMapping("/")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private IRedisService iRedisService;

    /**
     * 方法名：
     * 功能：添加
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/add")
    @ResponseBody
    public void test() {
        log.info("----test----start");
        System.out.println("start.....");
        RedisModel m = new RedisModel();
        m.setName("张三");
        m.setTel("1111");
        m.setAddress("深圳1");
        m.setKey("zhangsanKey01");
        iRedisService.put(m.getKey(), m, -1);

        RedisModel m2 = new RedisModel();
        m2.setName("张三2");
        m2.setTel("2222");
        m2.setAddress("深圳2");
        m2.setKey("zhangsanKey02");
        iRedisService.put(m2.getKey(), m2, -1);

        RedisModel m3 = new RedisModel();
        m3.setName("张三3");
        m3.setTel("2222");
        m3.setAddress("深圳2");
        m3.setKey("zhangsanKey03");
        iRedisService.put(m3.getKey(), m3, -1);

        log.info("----test----end");
    }

    /**
     * 方法名：getAll
     * 功能：查询所有对象
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/getAll")
    public Object getAll() {
        log.info("----getAll----start");
        return iRedisService.getAll();
    }

    /**
     * 方法名：getKeys
     * 功能：查询所有key
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/getKeys")
    public Object getKeys() {
        log.info("----getKeys----start");
        return iRedisService.getKeys();
    }

    /**
     * 方法名：getKey
     * 功能：根据key查询
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/getKey")
    public Object get() {
        log.info("----get----start");
        RedisModel m = new RedisModel();
        m.setKey("zhangsanKey02");
        return iRedisService.get(m.getKey());
    }

    /**
     * 方法名：remove
     * 功能：删除
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/remove")
    public void remove() {
        log.info("----remove----start");
        RedisModel m = new RedisModel();
        m.setKey("zhangsanKey01");
        iRedisService.remove(m.getKey());
        log.info("----remove----end");
    }

    /**
     * 方法名：isKeyExists
     * 功能：判断key是否存在
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/isKeyExists")
    public void isKeyExists() {
        log.info("----isKeyExists----start");
        RedisModel m = new RedisModel();
        m.setKey("zhangsanKey01");
        boolean flag = iRedisService.isKeyExists(m.getKey());
        log.info("----isKeyExists----end:"+flag);
    }

    /**
     * 方法名：count
     * 功能：查询当前缓存的数量
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/count")
    public Object count() {
        log.info("----count----start");
        return iRedisService.count();
    }

    /**
     * 方法名：empty
     * 功能：清空所有key
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/15 22:09
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/empty")
    public void empty() {
        log.info("----empty----start");
        iRedisService.empty();
    }
}
