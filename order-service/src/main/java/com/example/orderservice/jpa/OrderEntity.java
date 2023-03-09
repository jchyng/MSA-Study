package com.example.orderservice.jpa;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    //직렬화 = 데이터 전송할 때 마샬링, 언마샬링 하기 위해서
    //마샬링 = 한 객체의 메모리에서 표현방식을 저장 또는 전송에 적합한 다른 데이터 형식으로 변환하는 과정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false)
    private String qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;


    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;


    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;
}
