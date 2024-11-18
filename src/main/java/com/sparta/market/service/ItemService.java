package com.sparta.market.service;

import com.sparta.market.dto.ItemDeleteResponseDto;
import com.sparta.market.dto.ItemRequestDto;
import com.sparta.market.dto.ItemResponseDto;
import com.sparta.market.dto.list.ItemListResponseDto;
import com.sparta.market.entity.Item;
import com.sparta.market.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ItemResponseDto createPost(ItemRequestDto requestDto) {
        Item item = itemRepository.save(Item.createItem(requestDto));
        return new ItemResponseDto(item);
    }

    public List<ItemListResponseDto> getItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemListResponseDto(item)).collect(Collectors.toList());
    }

    @Transactional
    public ItemResponseDto updatePost(Long id, ItemRequestDto updateDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글 입니다."));
        item.update(updateDto);
        return new ItemResponseDto(item);
    }

    @Transactional
    public ItemDeleteResponseDto deletePost(Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글 입니다."));

        try{
            itemRepository.delete(item);
        } catch (Exception e){
            return new ItemDeleteResponseDto("오류 발생");
        }
        return new ItemDeleteResponseDto("삭제완료");
    }
}
