package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("category_name","我的最爱");
        map.put("category_type","102");
        int result=mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("你的最爱");
        productCategory.setCategoryType(103);
        int result=mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType(){
        ProductCategory result=mapper.findByCategoryType(102);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> result=mapper.findByCategoryName("我的最爱");
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void updateByCategoryType(){
        int result=mapper.updateByCategoryType("我的最不爱",102);
        Assert.assertEquals(1,result);
    }


    @Test
    public void updateByObject(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("你的最不爱");
        productCategory.setCategoryType(103);
        int result=mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deletByCategoryType(){
        int result=mapper.deleteByCategoryType(103);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory=mapper.selectByCategoryType(101);
        Assert.assertNotNull(productCategory);
    }


}