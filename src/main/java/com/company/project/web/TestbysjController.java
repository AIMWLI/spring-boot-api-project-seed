package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Testbysj;
import com.company.project.service.TestbysjService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.annotation.Resource;
import java.util.List;

/**
* Created by songj on 2022/01/17.
*/
@RestController
@RequestMapping("/testbysj")
public class TestbysjController {
    @Resource
    private TestbysjService testbysjService;

    @PostMapping("/add")
    public Result add(@RequestBody Testbysj testbysj) {
        testbysjService.save(testbysj);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        testbysjService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Testbysj testbysj) {
        testbysjService.update(testbysj);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Testbysj testbysj = testbysjService.findById(id);
        return ResultGenerator.genSuccessResult(testbysj);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Testbysj> list = testbysjService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
