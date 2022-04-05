package com.IMetA.IMetAwebservice.web.artist;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.repository.ArtistBoardRepository;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardDetailResponseDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardResponseDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.artist.dto.ArtistBoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArtistBoardService {

    private final ArtistBoardRepository artistBoardRepository;

    @Transactional
    public Long save(ArtistBoardSaveRequestDto requestDto, List<MultipartFile> fileList) {
        return artistBoardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ArtistBoardUpdateRequestDto requestDto, List<MultipartFile> fileList) {
        ArtistBoard artistBoard = artistBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: "+id));
        artistBoard.update(requestDto.getPieceBoard(), requestDto.getName(), requestDto.getNote(), requestDto.getImage(), requestDto.getEducation(), requestDto.getCareer());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        ArtistBoard artistBoard = artistBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: "+id));

        artistBoardRepository.delete(artistBoard);
    }

    @Transactional(readOnly = true)
    public Page<ArtistBoardResponseDto> getArtistBoard (String keyword, @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<ArtistBoard> artistBoardPage;

        if (keyword == null) {
            artistBoardPage = artistBoardRepository.findAll(pageable);
        }
        else {
            artistBoardPage = artistBoardRepository.findByNameContaining(pageable, keyword);
        }
        return new PageImpl<ArtistBoardResponseDto>(artistBoardPage.stream().map(ArtistBoardResponseDto::new).collect(Collectors.toList()), pageable, artistBoardPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public ArtistBoardDetailResponseDto getArtistBoardDetail (Long id) {

        ArtistBoard artistBoard = artistBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ArtistBoardDetailResponseDto(artistBoard);
    }
}
