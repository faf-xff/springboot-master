package com.example.demo.mapper;

import com.example.demo.entity.BrandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 路径：com.example.demo.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/5/19 21:00
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface ExcelMapper {

    List<BrandInfo> list();
}
