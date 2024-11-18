package com.sparta.market.dto;

import com.sparta.market.entity.Item;
import lombok.Data;

@Data
public class ItemResponseDto {

    /**
     * {
     *     “id” : 1,
     *    “username” : “한효승” ,
     *     “title” : “노트북 팝니다~!”,
     *     “content” : “이제 안쓰는 노트북을 처분하려고 해요.”
     *     “price” : 150000
     * }
     */
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
