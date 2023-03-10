package com.aiit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: jhzhong
 * @date: 2023/3/5 20:57
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer id;
    private String permissionName;
    private Date createTime;
}
