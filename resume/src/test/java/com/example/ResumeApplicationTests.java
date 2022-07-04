package com.example;
import com.example.entity.RequiredSkills;
import com.example.entity.ResumeInfo;
import com.example.entity.SkillInfo;
import com.example.entity.SkillRule;
import com.example.service.ResumeInfoService;
import com.example.service.SkillInfoService;
import com.example.service.SkillRuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ResumeApplication.class)
public class ResumeApplicationTests {
    @Autowired
    private SkillInfoService service;

    @Autowired
    private ResumeInfoService service1;

    @Autowired
    private SkillRuleService service2;


    @Test
    public void contextLoads() {
        ResumeInfo res = service1.findByIdForResume(1610252001);
        System.out.println(res);
    }


}
