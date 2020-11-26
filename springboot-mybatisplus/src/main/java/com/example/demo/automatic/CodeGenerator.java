package com.example.demo.automatic;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

/**
 * 类名：CodeGenerator.java
 * 功能：执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * 描述：
 * 创建人：typ
 * 创建时间：2018/11/20 15:34
 * 修改人：
 * 修改描述：
 * 修改时间：
 */
@Slf4j
public class CodeGenerator {

    /**
     * 方法名：
     * 功能：读取控制台内容
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/20 15:34
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 方法名：
     * 功能：代码生成
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/20 15:35
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "F:/workingExperience/workspace/workIeda/springboot-master/springboot-mybatisplus";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("typ"); // 注释作者
        gc.setDateType(ONLY_DATE); // 注释时间类型
        gc.setOpen(false);
        gc.setActiveRecord(true); //是否需要ActiveRecord特性
        gc.setEnableCache(false); // mapper.xml中开启二级缓存
        gc.setBaseResultMap(true); // mapper.xml 中使用ResultMap
        gc.setBaseColumnList(true); // mapper.xml中使用columList
        gc.setKotlin(true); //是否生成kotlin代码
        gc.setControllerName("%sController"); //自定义controoler类的命名格式，列如：XxxController.java
        gc.setServiceName("%sService"); //自定义service接口的命名格式，列如：XxxService.java
        gc.setServiceImplName("%sServiceImpl"); //自定义service实现类的命名格式，列如：XxxServiceImpl.java
        gc.setMapperName("%sMapper"); //自定义mapper接口的命名格式，列如：XxxMapper.java
        gc.setXmlName("%sMapper"); //自定义mapper.xml的命名格式，列如：XxxMapper.xml
        mpg.setGlobalConfig(gc);

        // 2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL); // 配置数据库类型
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("admin");
        mpg.setDataSource(dsc);

        // 4.包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名")); // 控制台输入方式
        pc.setParent("com.example.demo");
//        pc.setController("controller");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setServiceImpl("impl");
        mpg.setPackageInfo(pc);

        // 5.自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 6.自定mapper.xml生成路径
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 7.策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setCapitalMode(true); // 全局大写命名
//        strategy.setTablePrefix(new String[]{"tb_","tbs_"}); // 数据库表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名")); // 需要生成的表名
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}