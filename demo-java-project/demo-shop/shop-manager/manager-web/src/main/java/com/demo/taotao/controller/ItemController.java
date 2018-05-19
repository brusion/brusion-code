package com.demo.taotao.controller;

import com.demo.taotao.bean.TbItem;
import com.demo.taotao.service.ItemService;
import com.demo.taotao.service.ItemServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author brusion
 * @date 2018/5/13
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    @Test
    public void getBean(){
        itemService = new ItemServiceImp();
        TbItem itemById = itemService.getItemById(536563l);
        System.out.println(itemById.toString());
    }
}
