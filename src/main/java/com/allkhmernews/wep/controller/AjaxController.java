/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.allkhmernews.wep.controller;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Controller
public class AjaxController {
    @Autowired
    private ArticleService service;
    
    @GetMapping("/ajax")
    @ResponseBody
    public String ajax(ModelMap model){
        List<Article> article=service.finall();
         model.addAttribute("article", article);
    return("/ajax");
    }

} 
