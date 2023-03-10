package com.aiit.service.impl;

import com.aiit.dao.EmpDao;
import com.aiit.pojo.Emp;
import com.aiit.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jhzhong
 * @date: 2023/2/26 10:12
 * @desc:
 */
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpDao empDao;

    public List<Emp> getAllEmp() {
        return empDao.getAllEmp();
    }
}
