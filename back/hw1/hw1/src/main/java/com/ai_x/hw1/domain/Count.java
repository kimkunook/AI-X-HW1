package com.ai_x.hw1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name = "count_tb")
@Setter
@Getter
public class Count {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private Integer count;
}