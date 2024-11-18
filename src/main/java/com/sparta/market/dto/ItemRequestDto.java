package com.sparta.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemRequestDto {

    /**
     * {
     *     “username” : “한효승”,
     *     “title” : “노트북 팝니다~!”,
     *     “content” : “이제 안쓰는 노트북을 처분하려고 해요.”
     *     “price” : 150000
     * }
     */
    private String username;
    private String title;
    private String content;
    private int price;

}
