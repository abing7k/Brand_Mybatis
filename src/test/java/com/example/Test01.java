package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.server.mapper.TbBrandMapper;
import com.example.server.pojo.TbBrand;
import com.example.server.service.ITbBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @PROJECT_NAME: Brand_Mybatis
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/13 0013 17:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Test
    //增
    public void add(){
        TbBrand tbBrand = new TbBrand();
        tbBrand.setBrandName("666");
        tbBrandMapper.insert(tbBrand);
    }

    //删
    @Test
    public void delete(){
        tbBrandMapper.deleteById(2);
    }

    @Test
    //改
    public void update(){
        TbBrand tbBrand = new TbBrand();
        tbBrand.setId(1);
        tbBrand.setBrandName("666");
        tbBrandMapper.updateById(tbBrand);
    }

    //查
    @Test
    public void showAll(){
        List<TbBrand> tbBrands = tbBrandMapper.selectList(new QueryWrapper<>());
        for (TbBrand tbBrand : tbBrands) {
            System.out.println(tbBrand);
        }
    }


    //条件查询
    @Test
    public void showLike(){
        QueryWrapper<TbBrand> qeryWrapper = new QueryWrapper<>();
        qeryWrapper.like("brand_name","6");
        List<TbBrand> tbBrands = tbBrandMapper.selectList(qeryWrapper);
        for (TbBrand tbBrand : tbBrands) {
            System.out.println(tbBrand);
        }
    }

    //分页
    @Test
    public void show(){
        Page<TbBrand> rowPage = new Page(1, 2);
        QueryWrapper<TbBrand> qeryWrapper = new QueryWrapper<>();
        qeryWrapper.like("brand_name","6");
        Page<TbBrand> tbBrandPage = tbBrandMapper.selectPage(rowPage, qeryWrapper);
        System.out.println(tbBrandPage.getRecords());
    }

}
