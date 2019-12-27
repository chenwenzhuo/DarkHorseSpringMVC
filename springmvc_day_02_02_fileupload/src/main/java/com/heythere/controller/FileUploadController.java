package com.heythere.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/fileupload")
public class FileUploadController {
    @RequestMapping(path = "/traditionalJavaWeb")
    public String traditionalJavaWebFileUpload(HttpServletRequest request) throws Exception {
        System.out.println("Inside traditionalJavaWebFileUpload");

        //使用fileupload组件进行文件上传
        //获取上传路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("上传路径：" + uploadPath);
        //判断该路径是否存在，不存在则创建
        File uploadPathFile = new File(uploadPath);
        if (!uploadPathFile.exists()) {
            boolean mkdirSuccess = uploadPathFile.mkdirs();
            System.out.println("创建上传路径成功？ " + mkdirSuccess);
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        //解析request
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        //遍历
        for (FileItem item : fileItems) {
            if (!item.isFormField()) {
                //若item是文件项
                String filename = item.getName();//获取文件名
                //生成一段随机编码加入文件名中
                String uuid = UUID.randomUUID().toString().replace("-", "");
                item.write(new File(uploadPath, uuid + "_" + filename));//写入磁盘
                //删除上传的临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping(path = "/springMVC")
    public String springMVCFileUpload(
            HttpServletRequest request, MultipartFile fileUploader_springMVC) throws Exception {
        System.out.println("Inside springMVCFileUpload");

        //获取上传路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("上传路径：" + uploadPath);
        //判断该路径是否存在，不存在则创建
        File uploadPathFile = new File(uploadPath);
        if (!uploadPathFile.exists()) {
            boolean mkdirSuccess = uploadPathFile.mkdirs();
            System.out.println("创建上传路径成功？ " + mkdirSuccess);
        }
        //获取文件名
        String filename = fileUploader_springMVC.getOriginalFilename();
        //生成一段随机编码加入文件名中
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileUploader_springMVC.transferTo(new File(uploadPath, uuid + "_" + filename));
        return "success";
    }

    @RequestMapping(path = "/crossServer")
    public String crossServerFileUpload(MultipartFile fileUploader_crossServer) throws Exception {
        System.out.println("Inside crossServerFileUpload");

        String uploadPath = "http://localhost:9090/fileuploadServer_war_exploded/uploads";

        //获取文件名
        String filename = fileUploader_crossServer.getOriginalFilename();
        //生成一段随机编码加入文件名中
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //创建客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(uploadPath + "/" + filename);
        resource.put(fileUploader_crossServer.getBytes());
        //运行时报405 method not allowed错误,在tomcat的conf目录下的web.xml文件中加：
        /*<init-param>
            <param-name>readonly</param-name>
            <param-value>false</param-value>
          </init-param>*/

        return "success";
    }
}
