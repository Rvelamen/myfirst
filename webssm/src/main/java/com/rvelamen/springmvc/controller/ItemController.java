package com.rvelamen.springmvc.controller;

import com.rvelamen.springmvc.pojo.House;
import com.rvelamen.springmvc.pojo.Item;
import com.rvelamen.springmvc.pojo.QueryVo;
import com.rvelamen.springmvc.service.ItemService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 林继锐 on 2018/9/24.
 */
//注解，将Controller交给Spring 管理
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //配置处理器映射器
    //@RequestMapping : 里面放的是请求的url，和用户请求的url进行匹配
    //action 可以写也可以不写

    @RequestMapping("/itemList.action")
    public ModelAndView queryItemList() {
       //获取商品信息
        List<Item> list = this.itemService.queryItemList();


        //创建ModelAndView ,用来存放数据和视图
        ModelAndView modelAndView = new ModelAndView();

        //设置数据到模型中
        modelAndView.addObject("itemlist",list);
        //设置视图jsp，需要设置视图的物理地址
        modelAndView.setViewName("itemList2");

//        modelAndView.addObject("time", new Date());
//        modelAndView.getModel().put("name", "caoyc");
        return modelAndView;
    }

//    /**
//     * 根据商品id获取商品信息
//     */
//    @RequestMapping("/itemEdit")
//    public ModelAndView queryItemById(HttpServletRequest request){
//        //从request获取请求参数
//        String strId = request.getParameter("id");
//        Integer id = Integer.valueOf(strId);
//
//        //根据id查询商品数据
//        Item item = this.itemService.queryItemById(id);
//
//        //把结果传递给页面
//        ModelAndView modelAndView = new ModelAndView();
//
//        //把商品数据放在模型中
//        modelAndView.addObject("item",item);
//
//        //设置逻辑视图
//        modelAndView.setViewName("itemEdit");
//
//        return modelAndView;
//    }

    /**
     * 根据商品id获取商品输几局，使用model
     */
    @RequestMapping("itemEdit")
    public String queryItemById(HttpServletRequest request,Model model){
        String strId = request.getParameter("id");
        Integer id = Integer.valueOf(strId);

        Item item = this.itemService.queryItemById(id);

        model.addAttribute("item",item);
        return "itemEdit";
    }

    /**
     * 根据id 更新商品数据
     */
    @RequestMapping("updateItem")
    public String updateItem(Item item){
        //调用服务更新商品
        this.itemService.updateItemById(item);

        //返回视图
        return "success";
    }


//    /**
//     * 绑定包装数据
//     *
//     */
//    @RequestMapping("queryItem")
//    public String queryItem(QueryVo queryVo){
//        System.out.println(queryVo.getItem().getId());
//        System.out.println(queryVo.getItem().getName());
//
//        return "success";
//    }

    /**
     * 返回数组参数
     */
    @RequestMapping("queryItem")
    public String queryItem(QueryVo queryVo,Integer[] ids){
        System.out.println(queryVo.getItem().getId());
        System.out.println(queryVo.getItem().getName());

        System.out.println(queryVo.getIds().length);
        for(Integer i:queryVo.getIds())
            System.out.println(i);
        System.out.println(ids.length);
        for(Integer i:ids)
            System.out.println(i);
        return "success";
    }

    /**
     * 返回list参数
     */
    @RequestMapping("queryItem1")
    public String queryItem1(QueryVo vo,Integer[] ids,Model model){
        System.out.println(vo.getItemLists().size());
        if (vo.getItemLists() != null && vo.getItemLists().size()>0){
            for (Item i:vo.getItemLists()){
                String s = i.toString();
                System.out.println(s);
            }
        }

        List<Item> itemList = itemService.queryItemList();
        model.addAttribute("itemlist",itemList);

        return "success";
    }

    /**
     * 交互testJson的交互
     */
    @RequestMapping("Jsont")
    @ResponseBody
    public Item Jsont(){
        Item item = itemService.queryItemById(1);
        return item;
    }

    /**
     * 交互testJson的交互,接收
     */
    @RequestMapping("testJson")
    public @ResponseBody
    Item testJson(@RequestBody Item item){
        System.out.println(item);
        item.setName("飞机");
        return item;
    }


    /**
     * 初始界面的表格
     */
    @RequestMapping("selectFirst")
    @ResponseBody
    public List<House> selectFirst(){
        System.out.println("到这里啦###############################################");
        List<House> list = itemService.selectFirst();
        return list;
    }

    /**
     * 搜索房屋类型
     */
    @RequestMapping("HouseTypeSearch")
    public @ResponseBody List<House> HouseTypeSearch(@RequestBody String str){
        System.out.println(str);
        JSONObject json = JSONObject.fromObject(str);
        String form = json.getString("typeSearch");
        System.out.println(form);
        List<House> list = itemService.houseTypeSearch(form);
        System.out.println(list.size());
        return list;
    }

    /**
     * 添加二手房数据
     */
    @RequestMapping("AddDataHouse")
    @ResponseBody
    public void AddDataHouse(@RequestBody House house) {
        Date date = new Date();
        house.setFindtime(date);
        this.itemService.AddDataHouse(house);
    }

    /**
     * 删除房屋数据
     */

    @RequestMapping("deleteData")
    @ResponseBody
    public void deleteData(@RequestBody String str){
        this.itemService.deleteData(str);
    }


    /**
     * 更新房屋数据
     */
    @RequestMapping("updataData")
    @ResponseBody
    public void updataData(@RequestBody House house){
        Date date = new Date();
        house.setFindtime(date);
        house.toString();
        this.itemService.updateData(house);
    }


    /**
     * 显示主页
     */
    @RequestMapping("toindex")
    public String toindex(){
        return "index";
    }
}
