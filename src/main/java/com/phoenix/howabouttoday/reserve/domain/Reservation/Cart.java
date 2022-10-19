package com.phoenix.howabouttoday.reserve.domain.Reservation;

import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@DiscriminatorValue("cart")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class Cart extends Reservation {

    // @Builder
    // public Cart(Long reserveNum, Member member, Accommodation accommodation, Room room, Orders orders, ReserveStatus reserveStatus, LocalDate reserveUseStartDate, LocalDate reserveUseEndDate, int reservePrice, int reserveAdultCount, int reserveChildCount) {
    //     super(reserveNum, member, accommodation, room, orders, reserveStatus, reserveUseStartDate, reserveUseEndDate, reservePrice, reserveAdultCount, reserveChildCount);
    // }



}
