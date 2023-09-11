package com.anam.elibrary.service;

import com.anam.elibrary.entity.Circulation;
import com.anam.elibrary.repository.CirculationRepository;
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

        public int saveBookBorrowingData(Circulation circulation) {
            Date tanggalPinjam = circulation.getRequestDate();
            Date tanggalKembali = circulation.getReturnDate();
            long totalHariPinjam = (tanggalKembali.getTime() - tanggalPinjam.getTime()) / (24 * 60 * 60 * 1000);

            circulation.setCreatedAt(new Date());
            circulation.setUpdatedAt(new Date());
            circulation.setDays((int) totalHariPinjam);
            circulation.setStatus("IN PROGRESS");

            return circulationRepository.saveBookBorrowingData(circulation);
        }

        public int saveBookReturnData(Circulation circulation) {
            return circulationRepository.saveBookReturnData(circulation);
        }
    }
