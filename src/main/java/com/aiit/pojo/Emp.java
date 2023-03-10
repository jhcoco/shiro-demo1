package com.aiit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jhzhong
 * @date: 2023/2/26 10:04
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Integer empId;

    private String empName;

    private Integer age;

    private String sex;

    private String email;
}
