package com.IMetA.IMetAwebservice.web.contact;

import com.IMetA.IMetAwebservice.domain.enums.State;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardResponseDto;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController


public class ContactBoardController {

    private final ContactBoardService contactBoardService;

    @PostMapping("/contact")
    public Long save(@RequestBody ContactBoardSaveRequestDto requestDto) {
        return contactBoardService.save(requestDto);
    }

    @DeleteMapping("/contact/{id}")
    public Long delete(@PathVariable("id") Long id) {
        contactBoardService.delete(id);
        return id;
    }

    @GetMapping("/contact/")
    public Page<ContactBoardResponseDto> getContactBoard(@RequestParam(value = "state", required = false) State state, Pageable pageable) {
        return contactBoardService.getContactBoard(state, pageable);
    }



}
