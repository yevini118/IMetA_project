package com.IMetA.IMetAwebservice.web.contact;

import com.IMetA.IMetAwebservice.domain.ContactBoard;
import com.IMetA.IMetAwebservice.domain.enums.State;
import com.IMetA.IMetAwebservice.domain.repository.ContactBoardRepository;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardResponseDto;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardSaveRequestDto;
import com.IMetA.IMetAwebservice.web.contact.dto.ContactBoardDetailResponseDto;
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
public class ContactBoardService {

    private final ContactBoardRepository contactBoardRepository;

    @Transactional
    public Long save(ContactBoardSaveRequestDto requestDto, List<MultipartFile> fileList) {
        return contactBoardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id) {

        ContactBoard contactBoard = contactBoardRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        contactBoardRepository.delete(contactBoard);
    }

    @Transactional
    public void updateState(Long id, State state) {

        ContactBoard contactBoard = contactBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        contactBoard.update(state);
    }

    @Transactional(readOnly = true)
    public Page<ContactBoardResponseDto> getContactBoard (State state, @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ContactBoard> contactBoardPage;

        if (state == null) {
            contactBoardPage = contactBoardRepository.findAll(pageable);
        }
        else {
            contactBoardPage = contactBoardRepository.findByState(pageable, state);
        }
        return new PageImpl<ContactBoardResponseDto>(contactBoardPage.stream().map(ContactBoardResponseDto::new).collect(Collectors.toList()), pageable, contactBoardPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public ContactBoardDetailResponseDto getContactBoardDetail (Long id, Long password) {

        ContactBoard contactBoard = contactBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        if (contactBoard.getPassword().equals(password)) {
            return new ContactBoardDetailResponseDto(contactBoard);
        }
        else {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }
}
