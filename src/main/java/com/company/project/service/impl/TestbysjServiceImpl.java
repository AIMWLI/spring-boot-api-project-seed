package com.company.project.service.impl;

import com.company.project.dao.TestbysjMapper;
import com.company.project.model.Testbysj;
import com.company.project.service.TestbysjService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by songj on 2022/01/17.
 */
@Service
@Transactional
public class TestbysjServiceImpl extends AbstractService<Testbysj> implements TestbysjService {
    @Resource
    private TestbysjMapper testbysjMapper;

}
