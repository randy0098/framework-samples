package com.framework.backend;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class CodeGenerator {
  private static String url =
      "jdbc:postgresql://localhost:5432/backend_framework_dev?stringtype=unspecified";
  private static String username = "postgres";
  private static String password = "postgres";
  private static String driverClassName = "org.postgresql.Driver";
  private static String schema = "public";
  private static DbType dbType = DbType.POSTGRE_SQL;
  private static String parentPackage = "com.framework.backend";

  /** 读取控制台内容 */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入").append(tip).append("：");
    System.out.println(help.toString());
    String input = scanner.nextLine();
    return input;
  }

  /** RUN THIS */
  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    String rootProjectPath = System.getProperty("user.dir");
    log.debug("rootProjectPath: " + rootProjectPath);
    // 可以将代码生成到其它项目目录中去
    //    String childProjectName = scanner("子项目名称");
    //    String childProjectPath = rootProjectPath + "/" + childProjectName;

    String childProjectName = scanner("子项目名称（填空表示生成代码到当前项目）");
    // 默认将代码只生成到本项目目录中
    String childProjectPath = rootProjectPath;
    // childProjectName有值时将代码生成到其它子项目中去
    if (StringUtils.isNotBlank(childProjectName)) {
      childProjectPath =
          rootProjectPath.substring(0, rootProjectPath.lastIndexOf("\\") + 1) + childProjectName;
    }

    // 全局配置
    GlobalConfig gc = getGlobalConfig(childProjectPath);
    mpg.setGlobalConfig(gc);
    // 数据源配置
    DataSourceConfig dsc = getDataSourceConfig();
    mpg.setDataSource(dsc);
    // 包配置
    PackageConfig pc = getPackageConfig();
    mpg.setPackageInfo(pc);
    // 自定义配置
    InjectionConfig cfg = getInjectionConfig(pc, childProjectPath);
    mpg.setCfg(cfg);
    // 模板配置
    TemplateConfig templateConfig = getTemplateConfig();
    mpg.setTemplate(templateConfig);
    // 数据库表配置
    StrategyConfig strategy = getStrategyConfig(pc);
    mpg.setStrategy(strategy);
    // 选择 Beetl 引擎需要指定如下加，注意 pom 依赖必须有！
    mpg.setTemplateEngine(new BeetlTemplateEngine());
    mpg.execute();
  }

  /** 全局配置 */
  private static GlobalConfig getGlobalConfig(String childProjectPath) {
    GlobalConfig gc = new GlobalConfig();
    // 生成文件的输出目录
    gc.setOutputDir(childProjectPath + "/src/main/java");
    // 是否覆盖已有文件
    gc.setFileOverride(false);
    gc.setAuthor("code-generator");
    // 是否打开输出目录
    gc.setOpen(false);
    // 实体命名方式，生成xxxEntity
    gc.setEntityName("%s");
    // mapper命名方式，生成xxxMapper
    gc.setMapperName("%sMapper");
    // Mapper xml命名方式，生成xxxMapper
    gc.setXmlName("%sMapper");
    // service命名方式，生成xxxService
    gc.setServiceName("%sService");
    // service impl命名方式，生成xxxServiceImpl
    gc.setServiceImplName("%sServiceImpl");
    // controller命名方式，生成xxxController
    gc.setControllerName("%sController");
    // 自动生成mapper.xml中的baseResultMap
    gc.setBaseResultMap(true);
    // 自动生成mapper.xml中的Base_Column_List
    gc.setBaseColumnList(true);
    // 已修改模板entity.java.btl来支持生成springdoc注解
    gc.setSwagger2(true);
    return gc;
  }

  /** 数据源配置 */
  private static DataSourceConfig getDataSourceConfig() {
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(dbType);
    dsc.setUrl(url);
    // 数据库schema，POSTGRE_SQL,ORACLE,DB2类型的数据库需要指定SchemaName
    dsc.setSchemaName(schema);
    dsc.setDriverName(driverClassName);
    dsc.setUsername(username);
    dsc.setPassword(password);
    return dsc;
  }

  /** 包配置 */
  private static PackageConfig getPackageConfig() {
    PackageConfig pc = new PackageConfig();
    pc.setParent(parentPackage);
    String moduleName = scanner("模块名");
    // 模块名转成小写
    pc.setModuleName(moduleName.toLowerCase());
    return pc;
  }

  /** 自定义配置 */
  private static InjectionConfig getInjectionConfig(PackageConfig pc, String childProjectPath) {
    // 自定义配置
    InjectionConfig cfg =
        new InjectionConfig() {
          @Override
          public void initMap() {
            //            Map<String, Object> map = new HashMap<>();
            //            map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
            //            this.setMap(map);
          }
        };

    // ---------------------生成mapper.xml开始-------------------------------------
    //    // 如果模板引擎是beetl
    //    String templatePath = "/templates/mapper.xml.btl";
    //
    //    // 自定义输出配置
    //    List<FileOutConfig> focList = new ArrayList<>();
    //    // 自定义配置会被优先输出
    //    focList.add(
    //        new FileOutConfig(templatePath) {
    //          @Override
    //          public String outputFile(TableInfo tableInfo) {
    //            // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
    //            return childProjectPath
    //                + "/src/main/resources/mapper/"
    //                + pc.getModuleName()
    //                + "/"
    //                + tableInfo.getEntityName()
    //                + "Mapper"
    //                + StringPool.DOT_XML;
    //          }
    //        });
    // ---------------------生成mapper.xml结束-------------------------------------
    //
    //    cfg.setFileCreate(
    //        new IFileCreate() {
    //          @Override
    //          public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String
    // filePath) {
    //            // 判断自定义文件夹是否需要创建
    //            checkDir("调用默认方法创建的目录，自定义目录用");
    //            if (fileType == FileType.MAPPER) {
    //              // 已经生成 mapper 文件判断存在，不想重新生成返回 false
    //              return !new File(filePath).exists();
    //            }
    //            // 允许生成模板文件
    //            return true;
    //          }
    //        });
    //
    // ---------------------生成mapper.xml开始-------------------------------------
    //    cfg.setFileOutConfigList(focList);
    // ---------------------生成mapper.xml结束-------------------------------------
    return cfg;
  }

  /** 模板配置 */
  private static TemplateConfig getTemplateConfig() {
    TemplateConfig templateConfig = new TemplateConfig();
    templateConfig.setEntity("templates/entity.java");
    templateConfig.setController("templates/controller.java");
    templateConfig.setServiceImpl("templates/serviceImpl.java");
    templateConfig.setService("templates/service.java");
    templateConfig.setMapper("templates/mapper.java");
    // 此处生成的mapper.xml会放到java类目录中
    // templateConfig.setXml("templates/mapper.xml");
    // 设置mapper.xml使用自定义输出配置的方式来生成
    // templateConfig.setXml(null);
    // 设置为不生成mapper.xml
    templateConfig.disable(TemplateType.XML);
    return templateConfig;
  }

  /** 数据库表配置 */
  private static StrategyConfig getStrategyConfig(PackageConfig pc) {
    StrategyConfig strategy = new StrategyConfig();
    // 配置数据表与实体类名之间映射的策略
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 配置数据表的字段与实体类的属性名之间映射的策略
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // strategy.setSuperEntityClass("com.framework.backend.common.MyBaseEntity");
    // strategy.setSuperMapperClass("com.framework.backend.common.MyBaseMapper");
    // strategy.setSuperServiceClass("com.framework.backend.common.MyBaseService");
    // strategy.setSuperServiceImplClass("com.framework.backend.common.MyBaseServiceImpl");
    // strategy.setSuperControllerClass("com.framework.backend.common.MyBaseController");
    strategy.setRestControllerStyle(true);
    // 驼峰转连字符
    strategy.setControllerMappingHyphenStyle(false);
    // 启用lombok
    strategy.setEntityLombokModel(true);
    // 开启生成serialVersionUID
    strategy.setEntitySerialVersionUID(true);
    strategy.setInclude(scanner("表名").split(","));
    // 不用生成父类上的基本数据库表字段
    // strategy.setSuperEntityColumns(
    //    new String[] {"ID", "CREATE_USER", "CREATE_TIME", "UPDATE_USER", "UPDATE_TIME"});
    // 配置表前缀，生成实体时去除表前缀
    // 例：表名为utility_dicset，模块名为utility，去除前缀后剩下为dicset实体类。
    strategy.setTablePrefix(pc.getModuleName() + "_");
    return strategy;
  }
}
