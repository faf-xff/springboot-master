package com.example.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SpringbootDatasourceApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcTemplate db1JdbcTemplate;

    @Autowired
    private JdbcTemplate db2JdbcTemplate;

    /**
     * @methodName：testPrimary
     * @description：测试@Primary属性
     * @author：tanyp
     * @dateTime：2020/10/12 11:20
     * @Params： []
     * @Return： void
     * @editNote：
     */
    @Test
    void testPrimary() {
        // 不指定使用哪个JdbcTemplate对象时，会使用标注了@Primary属性的对象
        jdbcTemplate.update("insert into student(name,age) values(?,?)", new Object[]{"Java旅途", 18});
    }

    /**
     * @methodName：contextLoads
     * @description：测试多数据源
     * @author：tanyp
     * @dateTime：2020/10/12 11:21
     * @Params： []
     * @Return： void
     * @editNote：
     */
    @Test
    void contextLoads() {
        db1JdbcTemplate.update("insert into student(name,age) values(?,?)", new Object[]{"Java旅途", 18});
        db2JdbcTemplate.update("insert into student(name,age) values(?,?)", new Object[]{"Java旅途", 18});
    }

    /**
     * 测试表：
     * CREATE TABLE `student` (
     *    `student_id` int(30) NOT NULL AUTO_INCREMENT,
     *    `age` int(1) DEFAULT NULL COMMENT '年龄',
     *    `name` varchar(45) DEFAULT NULL COMMENT '姓名',
     *    `sex` int(1) DEFAULT NULL COMMENT '性别：1：男，2：女，0：未知',
     *    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     *    `status` int(1) DEFAULT NULL COMMENT '状态：1：正常，-1：删除',
     *    PRIMARY KEY (`student_id`)
     *  ) ENGINE=InnoDB CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='学生表'
     */

}
