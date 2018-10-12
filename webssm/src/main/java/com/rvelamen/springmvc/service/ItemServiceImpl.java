package com.rvelamen.springmvc.service;

import com.rvelamen.springmvc.mapper.HouseMapper;
import com.rvelamen.springmvc.mapper.ItemMapper;
import com.rvelamen.springmvc.pojo.House;
import com.rvelamen.springmvc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 林继锐 on 2018/9/25.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<Item> queryItemList(){
        List<Item> list = this.itemMapper.selectByExample(null);
        return list;
    }

    @Override
    public Item queryItemById(int id){
        Item item = this.itemMapper.selectByPrimaryKey(id);
        return item;
    }

    @Override
    public void updateItemById(Item item) {
        this.itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public List<House> selectFirst() {
        System.out.println("这里啦################################3");
        List<House> list = this.houseMapper.selectFirst();
        return list;
    }

    /**
     * 搜索房屋类型
     * @return
     */
    @Override
    public List<House> houseTypeSearch(String str) {
        List<House> list = this.houseMapper.houseTypeSearch(str);
        return list;
    }

    @Override
    public void AddDataHouse(House record) {
        this.houseMapper.addDataHouse(record);
    }

    @Override
    public void deleteData(String str) {
        this.houseMapper.deleteByPrimaryKey(Integer.parseInt(str));
    }

    /**
     * 更新房屋数据
     */
    @Override
    public void updateData(House record) {
        this.houseMapper.updateByPrimaryKey(record);
    }


}
