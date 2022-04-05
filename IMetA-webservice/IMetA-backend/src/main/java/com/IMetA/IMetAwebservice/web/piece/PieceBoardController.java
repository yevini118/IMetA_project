package com.IMetA.IMetAwebservice.web.piece;

import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardDetailResponseDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardResponseDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PieceBoardController {

    private final PieceBoardService pieceBoardService;

    @PostMapping("/piece")
    public Long save(@RequestPart("requestDto")PieceBoardSaveRequestDto requestDto, @RequestPart("fileList")List<MultipartFile> fileList) {
        return pieceBoardService.save(requestDto, fileList);
    }

    @PutMapping("/piece/{id}")
    public Long save(@PathVariable Long id, @RequestPart("requestDto")PieceBoardUpdateRequestDto requestDto, @RequestPart("fileList")List<MultipartFile> fileList) {
        return pieceBoardService.update(id, requestDto, fileList);
    }

    @DeleteMapping("/piece/{id}")
    public Long delete(@PathVariable Long id) {
        pieceBoardService.delete(id);
        return id;
    }

    @GetMapping("/piece/")
    public Page<PieceBoardResponseDto> getPieceBoard(@RequestParam(value = "keyword", required = false) String keyword, Pageable pageable) {
        return pieceBoardService.getPieceBoard(keyword, pageable);
    }

    @GetMapping("/piece/{id}")
    public PieceBoardDetailResponseDto getPieceBoardDetail(@PathVariable("id") Long id) {
        return pieceBoardService.getPieceBoardDetail(id);
    }
}
