package com.rvelamen.springmvc.pojo;

import java.util.List;

/**
 * Created by 林继锐 on 2018/9/25.
 */
public class QueryVo {

    private String houseType;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    private Item item;

    //用对象属性接受数组，属性名要同页面的name相同
    private Integer[] ids;

    //用对象的属性接收List集合
    private List<Item> itemLists;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List<Item> getItemLists() {
        return itemLists;
    }

    public void setItemLists(List<Item> itemLists) {
        this.itemLists = itemLists;
    }
}
