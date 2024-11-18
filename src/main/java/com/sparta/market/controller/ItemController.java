package com.sparta.market.controller;

import com.sparta.market.dto.ItemDeleteResponseDto;
import com.sparta.market.dto.ItemRequestDto;
import com.sparta.market.dto.ItemResponseDto;
import com.sparta.market.dto.list.ItemListResponseDto;
import com.sparta.market.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;

    // 판매 게시글 작성 테스트 x
    @PostMapping
    public ItemResponseDto createPost(@RequestBody ItemRequestDto requestDto){
        return itemService.createPost(requestDto);
    }

    // 판매 글 리스트
    @GetMapping
    public List<ItemListResponseDto> getItems(){
        return itemService.getItems();
    }

    // 판매 글 수정
    @PutMapping("/{id}")
    public ItemResponseDto updatePost(@PathVariable("id") Long id,
                                      @RequestBody ItemRequestDto updateDto){
        return itemService.updatePost(id, updateDto);
    }

    // 판매 글 삭제
    @DeleteMapping("/{id}")
    public ItemDeleteResponseDto deletePost(@PathVariable("id") Long id){
        return itemService.deletePost(id);
    }


}
