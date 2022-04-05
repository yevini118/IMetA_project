package com.IMetA.IMetAwebservice.web.piece;

import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.domain.enums.State;
import com.IMetA.IMetAwebservice.domain.repository.PieceBoardRepository;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardResponseDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardDetailResponseDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardResponseDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PieceBoardService {

    private final PieceBoardRepository pieceBoardRepository;

    @Transactional
    public Long save(PieceBoardSaveRequestDto requestDto, List<MultipartFile> fileList) {

        return pieceBoardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PieceBoardUpdateRequestDto requestDto, List<MultipartFile> fileList) {
        PieceBoard pieceBoard = pieceBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: "+id));
        pieceBoard.update(requestDto.getExhibition(), requestDto.getArtistBoard(), requestDto.getArtist(), requestDto.getTitle(), requestDto.getContent(), requestDto.getVrLink(), requestDto.getImage());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        PieceBoard pieceBoard = pieceBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: "+id));

        pieceBoardRepository.delete(pieceBoard);
    }

    @Transactional(readOnly = true)
    public Page<PieceBoardResponseDto> getPieceBoard (String keyword, @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<PieceBoard> pieceBoardPage;

        if (keyword == null) {
            pieceBoardPage = pieceBoardRepository.findAll(pageable);
        }
        else {
            pieceBoardPage = pieceBoardRepository.findByTitleContainingOrArtistContaining(pageable, keyword);
        }
        return new PageImpl<PieceBoardResponseDto>(pieceBoardPage.stream().map(PieceBoardResponseDto::new).collect(Collectors.toList()), pageable, pieceBoardPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public PieceBoardDetailResponseDto getPieceBoardDetail (Long id) {

        PieceBoard pieceBoard = pieceBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PieceBoardDetailResponseDto(pieceBoard);
    }
}
