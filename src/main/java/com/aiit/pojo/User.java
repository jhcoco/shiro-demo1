package com.aiit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jhzhong
 * @date: 2023/2/27 20:39
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String loginName;
    private String username;
    private String password;
    private String salt;
    private Integer status;
}
