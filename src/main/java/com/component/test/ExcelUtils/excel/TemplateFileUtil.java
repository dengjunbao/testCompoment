package com.component.test.ExcelUtils.excel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 15:20
 */
@Component
public class TemplateFileUtil {
    private static String templatesPath;
    @Value("${global.excel.templates.path:classpath:excel-templates/}")
    String tplPath;

    public TemplateFileUtil() {
    }

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return templatesPath.startsWith("classpath:") ? new FileInputStream(ResourceUtils.getFile(templatesPath + tempName)) : new FileInputStream(templatesPath + tempName);
    }

    @PostConstruct
    public void init() {
        templatesPath = this.tplPath;
    }
}
