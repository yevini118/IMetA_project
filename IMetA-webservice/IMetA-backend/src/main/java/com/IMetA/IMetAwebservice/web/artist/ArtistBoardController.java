package com.IMetA.IMetAwebservice.web.artist;

import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardDetailResponseDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardResponseDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArtistBoardController {

    private final ArtistBoardService artistBoardService;

    @PostMapping("/artist")
    public Long save(@RequestPart("requestDto") ArtistBoardSaveRequestDto requestDto, @RequestPart("fileList")List<MultipartFile> fileList) {
        return artistBoardService.save(requestDto, fileList);
    }

    @PutMapping("/artist/{id}")
    public Long save(@PathVariable Long id, @RequestPart("requestDto") ArtistBoardUpdateRequestDto requestDto, @RequestPart("fileList") List<MultipartFile> fileList) {
        return artistBoardService.update(id, requestDto, fileList);
    }

    @DeleteMapping("/artist/{id}")
    public Long delete(@PathVariable Long id) {
        artistBoardService.delete(id);
        return id;
    }

    @GetMapping("/artist/")
    public Page<ArtistBoardResponseDto> getArtistBoard(@RequestParam(value = "keyword", required = false) String keyword, Pageable pageable) {
        return artistBoardService.getArtistBoard(keyword, pageable);
    }

    @GetMapping("/artist/{id}")
    public ArtistBoardDetailResponseDto getArtistBoardDetail(@PathVariable("id") Long id) {
        return artistBoardService.getArtistBoardDetail(id);
    }
}
