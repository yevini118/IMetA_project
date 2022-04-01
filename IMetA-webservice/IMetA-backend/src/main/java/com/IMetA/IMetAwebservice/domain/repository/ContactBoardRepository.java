package com.IMetA.IMetAwebservice.domain.repository;

import com.IMetA.IMetAwebservice.domain.ContactBoard;
import com.IMetA.IMetAwebservice.domain.enums.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactBoardRepository extends JpaRepository<ContactBoard, Long> {

    Page<ContactBoard> findByState(Pageable pageable, State state);

}
