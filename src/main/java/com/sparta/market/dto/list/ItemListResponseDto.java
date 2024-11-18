package com.sparta.market.dto.list;

import com.sparta.market.entity.Item;
import lombok.Data;

@Data
public class ItemListResponseDto {

    private Long id;
    private String title;
    private String username;
    private int price;

    public ItemListResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.username = item.getUsername();
        this.price = item.getPrice();
    }
}
