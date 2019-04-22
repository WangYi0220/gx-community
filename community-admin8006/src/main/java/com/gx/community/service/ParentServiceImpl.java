package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.ParentMapper;
import com.gx.community.pojo.Parent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParentServiceImpl
 * @Description impl:ParentServiceImpl
 * @Author lxl
 * @Date 2019/4/2
 * @Version 1.0
 **/
@Service
@Transactional
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    /**
     * @return com.gx.community.admin.pojo.Parent
     * @Author lxl
     * @Description 查看家长信息列表,实现分页功能
     * @Param [pageNum]
     * @Date 18:56 2019/4/2
     **/
    @Override
    public PageInfo<Parent> queryParentList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Parent> parents = parentMapper.queryParentList();
        PageInfo<Parent> pageInfo = new PageInfo<>(parents);
        return pageInfo;
    }

    /**
     * @return com.gx.community.admin.pojo.Parent
     * @Author shiloh
     * @Description
     * @Date 18:56 2019/4/2
     * @Param [parUUID]
     **/
    @Override
    public Parent queryByParUUID(String parUUID) {
        return parentMapper.queryByParUUID(parUUID);
    }

    /**
     * @return void
     * @Author lxl
     * @Description 导入家长信息,并导入家长与学生关联表的信息
     * @Date 19:02 2019/4/2
     * @Param [multipartFile]
     **/
    @Override
    public void importParentInfo(MultipartFile multipartFile) {
        try {
            List<Parent> parents = new ArrayList<Parent>();
            List<Map<String,Object>> params = new ArrayList<>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);

            for (Row row : sheetAt) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                //从excel文件中获取家长的信息
                String parUUID = UUIDUtils.getUUID();
                String parName = row.getCell(2).getStringCellValue();
                row.getCell(3).setCellType(CellType.STRING);
                String telephone = row.getCell(3).getStringCellValue();
                String employer = row.getCell(4).getStringCellValue();
                parents.add(new Parent(parUUID,telephone,parName,telephone,employer));
                //从excel文件中获取家长与学生关联表的信息
                String stuUUID = row.getCell(0).getStringCellValue();
                String relation = row.getCell(5).getStringCellValue();
                Map<String,Object> map = new HashMap<>();
                map.put("stuUUID",stuUUID);
                map.put("parUUID",parUUID);
                map.put("relation",relation);
                params.add(map);

            }
            parents.forEach(parent -> {
                System.out.println("parent:" + parent.toString());
            });

            params.forEach(item -> {
                System.out.println("item:" + item.toString());
            });
            parentMapper.importParentInfo(parents,params);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return java.lang.Boolean
     * @Author lxl
     * @Description 删除家长信息
     * @Date 19:02 2019/4/2
     * @Param [parUUID]
     **/
    @Override
    public Boolean delParent(String parUUID) {
        parentMapper.delParent(parUUID);
        return true;
    }

    /**
     * @return java.lang.Boolean
     * @Author lxl
     * @Description 修改家长信息
     * @Date 19:03 2019/4/2
     * @Param [parent]
     **/
    @Override
    public Boolean updateParent(Parent parent) {
        parentMapper.updateParent(parent);
        return true;
    }
}
