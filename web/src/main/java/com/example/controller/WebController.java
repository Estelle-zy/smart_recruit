package com.example.controller;
import com.example.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 20:12
 * @内容:
 服务调用是通过RestTemplate对象，被调用服务的url地址和返回类型作为参数，然后就可以get被调用服务返回的数据了
 */
@Controller
@RequestMapping("/api/web")
public class WebController {
    @Autowired
    private RestTemplate restTemplate;

    //求职者分页查看全部招聘信息
    @GetMapping("/findAll")
    public String find(Model model,
                       @RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "2") int pageSize){
        //想recruit服务发起请求，分页查看全部招聘信息
        String url = "http://recruit/api/recruit/queryAll"+"?pageNum="+pageNum+"&pageSize="+pageSize;
        ResponseResult result = restTemplate.getForObject(url, ResponseResult.class);
        System.out.println("web服务和recruit服务通了。。。。。。");
        Map data = (Map)result.getData();
        System.out.println(data);
        model.addAttribute("data",data.get("list"));
        model.addAttribute("pageNum",data.get("pageNum"));
        model.addAttribute("pages",data.get("pages"));
        model.addAttribute("prePage",data.get("prePage"));
        model.addAttribute("nextPage",data.get("nextPage"));
        System.out.println(data.get("prePage"));
        System.out.println(data.get("nextPage"));
        return "all_recruit_info";
    }

    //求职者查看某一个招聘信息的具体情况
    @GetMapping("/findDetail")
    public String findDetail(Model model,Integer id){
        //向recruit服务发起请求，查看招聘信息的详情
        String url = "http://recruit/api/recruit/findById?id="+id;
        ResponseResult result = restTemplate.getForObject(url, ResponseResult.class);
        model.addAttribute("data",result.getData());
        return "company_detail";
    }

    //招聘者查看某一人的简历详情
    @GetMapping("/findDetail2")
    public String findDetail2(Model model,Integer id){
        //向resume服务发起请求，查看某个人的具体简历
        String url = "http://resume/api/resume/findDetail?id="+id;
        ResponseResult result = restTemplate.getForObject(url, ResponseResult.class);
        System.out.println("web服务和resume服务通了。。。。。。");
        model.addAttribute("data",result.getData());
        return "resume_detail";
    }

    //求职者填写简历
    @GetMapping("/writeResume")
    public String writeResume(){
        return "writeResume";
    }


    //招聘者查看全部的简历（这里就不再分页了，太麻烦了）
    @GetMapping("/findAll2")
    public String find2(Model model){
        //向resume服务发起请求，查看全部简历信息
        String url = "http://resume/api/resume/queryAll";
        ResponseResult result = restTemplate.getForObject(url, ResponseResult.class);
        System.out.println("web服务和resume服务通了。。。。。。");
        model.addAttribute("data",result.getData());
        return "all_resume_info";
    }

    //招聘者查看全部的简历分数，并按照分数做一个高低排序
    @GetMapping("/findAll3")
    public String find3(Model model){
        //向resume服务发起请求，查看全部简历分数
        String url = "http://resume/api/resume/queryAll2";
        ResponseResult result = restTemplate.getForObject(url, ResponseResult.class);
        System.out.println("web服务和resume服务通了。。。。。。");
        model.addAttribute("data",result.getData());
        return "all_resumeScore";
    }


}
