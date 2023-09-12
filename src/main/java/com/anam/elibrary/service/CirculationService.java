package com.anam.elibrary.service;

import com.anam.elibrary.dto.CirculationDTO;
import com.anam.elibrary.entity.Book;
import com.anam.elibrary.entity.Circulation;
import com.anam.elibrary.entity.Member;
import com.anam.elibrary.repository.CirculationRepository;
import com.anam.elibrary.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CirculationService {

    @Autowired
    private CirculationRepository circulationRepository;

    public List<Circulation> findAll() {
        return circulationRepository.findAll();
    }

    public int saveBookBorrowingData(CirculationDTO circulationDTO) {
        Date requestDate = DateUtil.convertStringToDate("yyyy-MM-dd", circulationDTO.getRequestDate());
        Date returnDate = DateUtil.convertStringToDate("yyyy-MM-dd", circulationDTO.getReturnDate());

        // totalHariPinjam = (tanggal kembali - tanggal pinjam)
        long days = (returnDate.getTime() - requestDate.getTime()) / (24 * 60 * 60 * 1000);

        Circulation circulation = new Circulation();
        circulation.setBookId(circulationDTO.getBookId());
        circulation.setMemberId(circulationDTO.getMemberId());
        circulation.setRequestDate(requestDate);
        circulation.setReturnDate(returnDate);
        circulation.setCreatedAt(new Date());
        circulation.setUpdatedAt(new Date());
        circulation.setDays((int) days);
        circulation.setStatus("IN PROGRESS");
        circulation.setLateDays(circulationDTO.getLateFees());

        return circulationRepository.saveBookBorrowingData(circulation);
    }

    public int saveBookReturnData(Circulation circulation) {
        return circulationRepository.saveBookReturnData(circulation);
    }

    public int cancelRequest(int id) {
        Circulation circulation = new Circulation();
        circulation.setId(id);
        circulation.setUpdatedAt(new Date());
        return circulationRepository.cancelRequest(circulation);
    }
}
