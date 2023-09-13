package com.anam.elibrary.service;

import com.anam.elibrary.dto.CirculationDTO;
import com.anam.elibrary.entity.Circulation;
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

    // untuk simpan data peminjaman
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

    // untuk simpan data pengembalian
    public int saveBookReturnData(CirculationDTO circulationDTO, int id) {
        Circulation circulationFindById = findById(id);

        Date returnDate = circulationFindById.getReturnDate();
        Date actualReturnDate = DateUtil.convertStringToDate("yyyy-MM-dd", circulationDTO.getActualReturnDate());

        // totalHariTerlambat = (tanggal actual kembali - tanggal kembali)
        long lateDays = (actualReturnDate.getTime() - returnDate.getTime()) / (24 * 60 * 60 * 1000);

        // biaya keterlambatan = totalHariTerlambat * biaya telat per-hari
        int totalLateFees = (int) (lateDays * circulationFindById.getLateFees());

        Circulation circulation = new Circulation();
        circulation.setActualReturnDate(actualReturnDate);
        circulation.setLateDays((int) lateDays);
        circulation.setTotalLateFees(totalLateFees);
        circulation.setId(id);

        return circulationRepository.saveBookReturnData(circulation);
    }

    public int cancelRequest(int id) {
        Circulation circulation = new Circulation();
        circulation.setId(id);
        circulation.setUpdatedAt(new Date());
        return circulationRepository.cancelRequest(circulation);
    }

    public Circulation findById(int id) {
        return circulationRepository.findById(id);
    }
}
