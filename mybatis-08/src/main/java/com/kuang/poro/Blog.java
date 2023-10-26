package com.kuang.poro;

import lombok.Data;

import java.util.Date;
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //字段名与属性不一致
    private int views;
}
