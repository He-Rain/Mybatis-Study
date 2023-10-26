package com.kuang.poro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//建一个东西，尽量将它序列化加上，否则又可能报错，我们需要将实体类序列化implements Serializable
public class User implements Serializable {
    private int id;
    private  String name;
    private String pwd;
}
