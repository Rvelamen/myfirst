package com.rvelamen.springmvc.service;

import com.rvelamen.springmvc.pojo.House;
import com.rvelamen.springmvc.pojo.Item;

import java.util.List;

/**
 * Created by 林继锐 on 2018/9/25.
 */
public interface ItemService {
    /**
     * 查询商品列表
     */
    List<Item> queryItemList();

    /**
     *
     * 根据商品id查询商品
     */
    Item queryItemById(int id);


    /**
     * 根据id更新商品
     */
    void updateItemById(Item item);

    /**
     * 初始页面列表放回数据
     */
    List<House> selectFirst();

    /**
     * 搜索房屋类型
     * @return
     */
    List<House> houseTypeSearch(String str);

    /**
     * 添加房子数据
     */
    void AddDataHouse(House record);

    /**
     * 删除房子数据
     */
    void deleteData(String str);

    /**
     * 更新房屋数据
     */
    void updateData(House record);
}
