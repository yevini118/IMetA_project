package com.IMetA.IMetAwebservice.domain.repository;

import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.web.piece.dto.PieceBoardResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PieceBoardRepository extends JpaRepository<PieceBoard, Long> {

    public Page<PieceBoard> findByTitleContainingOrArtistContaining(Pageable pageable, String keyword);
}
