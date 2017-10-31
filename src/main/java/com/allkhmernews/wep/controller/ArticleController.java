package com.allkhmernews.wep.controller;


import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.categoryfilter.CategoryFilter;
import com.allkhmernews.wep.service.ArticleServiceIm;
import com.allkhmernews.wep.service.category.CategoryService;
import com.allkhmernews.wep.service.upload.UploadService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.apache.velocity.texen.util.FileUtil.file;

/**
 * Created by User on 12-Jun-17.
 */
@Controller
public class ArticleController {
    private ArticleServiceIm articleServiceIm;
    @Autowired
    private CategoryService categoryService;
@Autowired
private UploadService uploadService;
    @Autowired
    public ArticleController(ArticleServiceIm articleService){
        this.articleServiceIm=articleService;
    }
//    @Autowired
//    public ArticleController(CategoryService categoryService){
//        this.categoryService = categoryService;
//    }
    @RequestMapping(value = "/index", method= RequestMethod.GET)
    public String getHomePage(ModelMap model){
        List<Article> articles=articleServiceIm.findAll(1);
        model.addAttribute("article", articles);
        model.addAttribute("page",1);
        model.addAttribute("totalpage",articleServiceIm.totalPage());
        return "article";

    }
    @RequestMapping(value = "/index/page", method= RequestMethod.GET)
    public String getPagInation(@RequestParam("page") Integer page, ModelMap model){
        List<Article> articles=articleServiceIm.findAll(page);
        model.addAttribute("article", articles);
        model.addAttribute("page",page);
        model.addAttribute("totalpage",articleServiceIm.totalPage());
        return "article";

    }
    //view
    @GetMapping("/index/view")
    public String getById(ModelMap model, @RequestParam("id")  Integer id){
       Article articles=articleServiceIm.findOne(id);
       model.addAttribute("view",articles);
       return "view";
    }
    @GetMapping("/index/remove")
    public String getRemoveById(ModelMap model, @RequestParam("id")  Integer id){
        boolean articles= articleServiceIm.remove(id);
        model.addAttribute("article",articles);
        return "redirect:/index";
    }

    //add
    @GetMapping("/index/add")
    public String addArticle(ModelMap model){
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categoryService.findAll());
        return "addnew";
    }
//Save

    @PostMapping("/index/save")
    public String actionSave(@RequestParam("file") MultipartFile file, @Valid Article article, BindingResult result, ModelMap model){


        if(result.hasErrors())
        {

            System.out.println("Error ");
            model.addAttribute("addStatus",true);
            model.addAttribute("article",article);
            model.addAttribute("categories", categoryService.findAll());
            return "addnew";
        }
    String thumbanail = uploadService.upload(file);
        article.setThumbnail(thumbanail);


        if (articleServiceIm.save(article)){
            System.out.println("success");
        }

        return "redirect:/index";

    }
    @GetMapping("/index/edit/{id}")
    public String updateArtile(ModelMap modelMap,@PathVariable("id") Integer id){
        modelMap.addAttribute("article",articleServiceIm.findOne(id));
        modelMap.addAttribute("categories", categoryService.findAll());
        modelMap.addAttribute("addStatus",false);
        return "update";
    }
    @PostMapping("/index/update")
    public String actionUpdate(@RequestParam("file") MultipartFile file, @Valid Article article, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("");
            return "update";
        }
        String thumbanail = uploadService.upload(file);
        article.setThumbnail(thumbanail);
        if(articleServiceIm.update(article)){
            System.out.println("Success Update!!!");
        }
        return "redirect:/index";
    }
  @GetMapping("/index/search")
    public String getSearch(CategoryFilter filter, ModelMap model){
        System.out.println(filter);
        model.addAttribute("article",articleServiceIm.search(filter));
        return "article";
    }
    //Change Language
    @GetMapping("/index/international")
    public String getInternationalPage()  {
        return "redirect:/index";
    }
    @GetMapping("/login")
    public String admin(){
        return "login";
    }




//    String Location="UploadData/";
//    @GetMapping("/upload")
//    public String uploadpage()
//    {
//        return "upload";
//    }
//
//    @PostMapping("/file/upload")
//    public String uploaded(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        try {
//            byte[] bytes=file.getBytes();
//            Path path= Paths.get(Location, file.getOriginalFilename());
//            Files.write(path, bytes);
//            System.out.println("file saved to : "+path);
//        } catch (IOException ex) {
//            System.out.println("Error while saving file");
//        }
//       String uploadPath = request.getServletContext().getRealPath("UploadData");
//        System.out.println(uploadPath);
//
//        try {
//            Files.copy(file.getInputStream(),Paths.get(uploadPath,file.getOriginalFilename()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return "upload";
//    }

}
