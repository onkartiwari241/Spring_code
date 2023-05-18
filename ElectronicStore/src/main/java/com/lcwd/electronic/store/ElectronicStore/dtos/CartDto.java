package com.lcwd.electronic.store.ElectronicStore.dtos;

import com.lcwd.electronic.store.ElectronicStore.entities.Cartitem;
import com.lcwd.electronic.store.ElectronicStore.entities.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartDto {

    private String cartId;
    private Date createdDate;


    private UserDto user;

    private List<CartItemDto> cartitemList = new ArrayList<>();

}

