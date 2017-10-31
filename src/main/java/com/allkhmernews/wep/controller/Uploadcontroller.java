package com.allkhmernews.wep.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletRequest;
        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.UUID;

/**
 * Created by MSI on 7/6/2017.
 */
@Controller
public class Uploadcontroller {

    private static String uploadpath = "store/";
    @GetMapping("/index/upload")
    public String uploadPage(){
        return "upload";
    }

    @PostMapping("/index/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request){
//        try{
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(uploadpath + file.getOriginalFilename());
////            Files.write(path,bytes);
//            System.out.println(file.getOriginalFilename());
String testpath = "/key/image";
File path = new File(testpath);
            System.out.println(testpath);
            if(!path.exists());
            path.mkdirs();
            String fileName = file.getOriginalFilename();
            fileName= UUID.randomUUID()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
        System.out.println(fileName);

        try {
            Files.copy(file.getInputStream(), Paths.get(testpath,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

         return "upload";
    }


}