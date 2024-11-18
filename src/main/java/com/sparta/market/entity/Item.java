package com.sparta.market.entity;

import com.sparta.market.dto.ItemRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    private Item(String title, String content, int price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public static Item createItem(ItemRequestDto dto){
        return new Item(dto.getTitle(), dto.getContent(), dto.getPrice(), dto.getUsername());
    }

    public void update(ItemRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.price = dto.getPrice();
        this.username = dto.getUsername();
    }
}
