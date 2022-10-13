package com.phoenix.howabouttoday.board.entity;


import com.phoenix.howabouttoday.payment.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="T_REVIEW")

public class Review {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reviewNum;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_num")
    private Order order;







}
