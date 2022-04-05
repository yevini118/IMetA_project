package com.IMetA.IMetAwebservice.web.contact;

import com.IMetA.IMetAwebservice.domain.enums.State;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardResponseDto;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContactBoardController {

    private final ContactBoardService contactBoardService;

    @PostMapping("/contact")
    public Long save(@RequestPart("requestDto") ContactBoardSaveRequestDto requestDto, @RequestPart("fileList")List<MultipartFile> fileList) {
        return contactBoardService.save(requestDto, fileList);
    }

    @DeleteMapping("/contact/{id}")
    public Long delete(@PathVariable("id") Long id) {
        contactBoardService.delete(id);
        return id;
    }

    @PutMapping("/contact/{id}")
    public Long updateState(@PathVariable Long id, @RequestParam(value = "state") State state) {
        contactBoardService.updateState(id, state);
        return id;
    }

    @GetMapping("/contact/")
    public Page<ContactBoardResponseDto> getContactBoard(@RequestParam(value = "state", required = false) State state, Pageable pageable) {
        return contactBoardService.getContactBoard(state, pageable);
    }

    @GetMapping("/contct/{id}")
    public ContactBoardDetailResponseDto getContactBoardDetail(@PathVariable("id") Long id, @RequestParam(value = "password") Long password) {
        return contactBoardService.getContactBoardDetail(id, password);
    }



}
