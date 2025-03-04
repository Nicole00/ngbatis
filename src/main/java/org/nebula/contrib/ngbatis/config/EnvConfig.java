package org.nebula.contrib.ngbatis.config;

// Copyright (c) 2022 All project authors and nebula-contrib. All rights reserved.
//
// This source code is licensed under Apache 2.0 License.

import org.nebula.contrib.ngbatis.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * 环境配置类，用于存放框架的配置信息
 *
 * @author yeweicheng
 * <br>Now is history!
 */
@Configuration
public class EnvConfig {

    /**
     * xml 所采用的模板引擎策略
     */
    @Autowired
    private TextResolver textResolver;
    /**
     * 结果处理路由策略
     */
    @Autowired
    private ResultResolver resultResolver;
    /**
     * 执行到数据库前的参数替换策略
     */
    @Autowired
    private ArgsResolver argsResolver;
    /**
     * 复杂对象，转换成 xml 可访问的参数名格式化策略
     */
    @Autowired
    private ArgNameFormatter argNameFormatter;
    /**
     * mapper.xml 解析时的配置，及声明 xml 标签用途跟 xml文件存放位置的配置。
     */
    @Autowired
    private ParseCfgProps cfgProps;
    /**
     * Springboot 应用上下文
     */
    @Autowired
    private ApplicationContext context;
    /**
     * Nebula 连接配置
     */
    @Autowired
    private NebulaJdbcProperties properties;
    /**
     * 主键生成器
     */
    @Autowired(required = false)
    private PkGenerator pkGenerator;


    @Bean
    public Env getEnv() {
        return new Env(
                textResolver,
                resultResolver,
                argsResolver,
                argNameFormatter,
                cfgProps,
                context,
                properties.getUsername(),
                properties.getPassword(),
                true,
                properties.getSpace(),
                pkGenerator
        );
    }


    public TextResolver getTextResolver() {
        return textResolver;
    }

    public void setTextResolver(TextResolver textResolver) {
        this.textResolver = textResolver;
    }

    public ResultResolver getResultResolver() {
        return resultResolver;
    }

    public void setResultResolver(ResultResolver resultResolver) {
        this.resultResolver = resultResolver;
    }

    public ArgsResolver getArgsResolver() {
        return argsResolver;
    }

    public void setArgsResolver(ArgsResolver argsResolver) {
        this.argsResolver = argsResolver;
    }

    public ArgNameFormatter getArgNameFormatter() {
        return argNameFormatter;
    }

    public void setArgNameFormatter(ArgNameFormatter argNameFormatter) {
        this.argNameFormatter = argNameFormatter;
    }

    public ParseCfgProps getCfgProps() {
        return cfgProps;
    }

    public void setCfgProps(ParseCfgProps cfgProps) {
        this.cfgProps = cfgProps;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public NebulaJdbcProperties getProperties() {
        return properties;
    }

    public void setProperties(NebulaJdbcProperties properties) {
        this.properties = properties;
    }
}
