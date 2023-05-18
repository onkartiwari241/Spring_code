package com.lcwd.electronic.store.ElectronicStore.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddItemToCartRequest {

    private String productId;
    private int quantity;
}
