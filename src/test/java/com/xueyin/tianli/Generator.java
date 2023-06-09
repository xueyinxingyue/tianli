package com.xueyin.tianli;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {
        /**
         * 第一步： 使用代码生成器
         */
        //怎么用代码生成器呢？
        // 1.创建代码生成器对象
        // 2.执行代码生成器 mp包里面的AutoGenerator
        AutoGenerator autoGenerator = new AutoGenerator();
        // 告诉它怎么生成，在哪生成

        //datasource数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tianli?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        autoGenerator.setDataSource(dataSource);

        /**
         * 第二步： 设置全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        //设置代码输出目录
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //设置完之后是否打开资源管理器 NO
        globalConfig.setOpen(false);
        //设置作者
        globalConfig.setAuthor("xueyin");
        //设置是否覆盖原始生成的文件
        globalConfig.setFileOverride(false);
        //设置数据层接口名，%s为占位符 代表数据库中的表名或模块名
        globalConfig.setMapperName("%sMapper");
        //设置id生成策略
        globalConfig.setIdType(IdType.AUTO);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 第三步： 设置包名相关配置
         */
        PackageConfig packageConfig = new PackageConfig();
        //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setParent("com.xueyin.tianli");
        //设置实体类包名
        packageConfig.setEntity("entity");
        //设置数据层包名
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);
        // 自定义配置 设置mapper.xml路径
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        //模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") +
                        "/src/main/resources/com/xueyin/tianli/mapper/" + tableInfo.getEntityName() + "Mapper" +
                        StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        // 关闭默认 xml 生成 调整生成至指定目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        autoGenerator.setTemplate(tc);
        autoGenerator.setCfg(cfg);

        /**
         * 第四步： 策略设置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置当前参与生成的表名，参数为可变参数 生成指定表
        strategyConfig.setInclude("user_notification");
        //设置数据库表的前缀名称，模块名=数据库表名-前缀名 User=tbl_user - tbl_
        strategyConfig.setTablePrefix("t_");
        //是否启用Rest风格
        strategyConfig.setRestControllerStyle(true);
        // //设置乐观锁字段名
        // strategyConfig.setVersionFieldName("version");
        // //设置逻辑删除字段名
        // strategyConfig.setLogicDeleteFieldName("deleted");
        // 设置是否启用Lombok
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();    //执行
    }
}
