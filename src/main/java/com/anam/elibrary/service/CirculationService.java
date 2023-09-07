package com.anam.elibrary.service;

import com.anam.elibrary.entity.Circulation;
import com.anam.elibrary.repository.CirculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirculationService {

        @Autowired
        private CirculationRepository circulationRepository;

        public List<Circulation> findAll() {
            return circulationRepository.findAll();
        }
    }
