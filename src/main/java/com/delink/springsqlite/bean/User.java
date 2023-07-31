package com.delink.springsqlite.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Autor cengdan
 * @Date 2023/7/3123:06
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
