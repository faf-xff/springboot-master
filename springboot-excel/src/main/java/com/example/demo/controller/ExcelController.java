package com.example.demo.controller;

import com.example.demo.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 路径：com.example.demo.controller
 * 类名：
 * 功能：excel导入导出
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/19 9:58
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 方法名：
     * 功能：导出
     * 描述：文件格式为xls或xlsx
     * 创建人：typ
     * 创建时间：2018/10/19 10:06
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/export")
    public String exportExcel(HttpServletResponse response, String fileName, Integer pageNum, Integer pageSize) {
        if (fileName == null || "".equals(fileName)) {
            return "文件名不能为空！";
        } else {
            if (fileName.endsWith("xls")) {
                Boolean isOk = excelService.exportExcel(response, fileName, 1, 10);
                if (isOk) {
                    return "导出成功！";
                } else {
                    return "导出失败！";
                }
            }
            return "文件格式有误！";
        }
    }

    /**
     * 方法名：import
     * 功能：导入
     * 描述：文件格式为xls或xlsx
     * 创建人：typ
     * 创建时间：2018/10/19 10:06
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/import")
    public String importExcel(String fileName) {
        if (fileName == null && "".equals(fileName)) {
            return "文件名不能为空！";
        } else {
            if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
                Boolean isOk = excelService.importExcel(fileName);
                if (isOk) {
                    return "导入成功！";
                } else {
                    return "导入失败！";
                }
            }
            return "文件格式错误！";
        }
    }

}
