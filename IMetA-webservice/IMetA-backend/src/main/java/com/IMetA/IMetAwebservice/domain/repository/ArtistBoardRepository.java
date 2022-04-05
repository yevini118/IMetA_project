package com.IMetA.IMetAwebservice.domain.repository;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistBoardRepository extends JpaRepository<ArtistBoard, Long> {

    public Page<ArtistBoard> findByNameContaining(Pageable pageable, String keyword);
}
