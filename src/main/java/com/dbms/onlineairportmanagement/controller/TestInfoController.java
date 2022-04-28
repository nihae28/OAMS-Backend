package com.dbms.onlineairportmanagement.controller;
import com.dbms.onlineairportmanagement.repository.TestInfoRepository;
import com.dbms.onlineairportmanagement.model.Test_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/testinfo")
public class TestInfoController {

    @Autowired
    private TestInfoRepository test_info;

    @GetMapping("/gettests")
    public List<Test_info> getAllTestInfo(){
        return test_info.findAll();
    }

    // build create employee REST API
    @PostMapping("/addtestinfo")
    public Test_info createTest(@RequestBody Test_info ti) {
        return test_info.save(ti);
    }

}
