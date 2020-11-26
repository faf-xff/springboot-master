package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.entity.BrandInfo;
import com.example.demo.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 路径：com.example.demo.controller
 * 类名：EasyPoiExcelController
 * 功能：使用easypoi注解进行导入导出
 * 备注：
 * 创建人：typ
 * 创建时间：2019/5/19 20:00
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
@RequestMapping("/easypoi")
public class EasyPoiExcelController {

    private static final Logger log = LoggerFactory.getLogger(EasyPoiExcelController.class);

    @Autowired
    public ExcelService excelService;

    /**
     * 方法名：importExcel
     * 功能：导入
     * 描述：
     * 创建人：typ
     * 创建时间：2019/5/19 20:02
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public String importExcel(String fileName) {
        return "";
    }

    /**
     * 方法名：exportExcel
     * 功能：导出
     * 描述：
     * 创建人：typ
     * 创建时间：2019/5/19 20:03
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response){
        log.info("请求 exportExcel start ......");

        // 获取用户信息
        List<BrandInfo> list = excelService.list();

        try {
            // 设置响应输出的头类型及下载文件的默认名称
            String fileName = new String("用户信息表.xls".getBytes("utf-8"), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel;charset=gb2312");

            //导出
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), BrandInfo.class, list);
            workbook.write(response.getOutputStream());
            log.info("请求 exportExcel end ......");
        } catch (IOException e) {
            log.info("请求 exportExcel 异常：{}", e.getMessage());
        }
    }
}
