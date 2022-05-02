package com.dbms.onlineairportmanagement.controller;
import com.dbms.onlineairportmanagement.repository.ExpertRepository;
import com.dbms.onlineairportmanagement.model.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private ExpertRepository expert;

    @GetMapping("/getexperts")
    public List<Test_info> getAllExperts(){
        return test_info.findAll();
    }

    // build create employee REST API
    @PostMapping("/addexpert")
    public expert createExpert(@RequestBody expert ti) {
        return expert.save(ti);
    }

}
