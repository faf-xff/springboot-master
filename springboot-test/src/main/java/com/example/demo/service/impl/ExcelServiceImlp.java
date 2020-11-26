package com.example.demo.service.impl;

import com.example.demo.entity.BrandInfo;
import com.example.demo.mapper.ExcelMapper;
import com.example.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路径：com.example.demo.service.impl
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/5/19 20:52
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Service
public class ExcelServiceImlp implements ExcelService {

    @Autowired
    private ExcelMapper excelMapper;

    @Override
    public List<BrandInfo> list() {
        return excelMapper.list();
    }
}
