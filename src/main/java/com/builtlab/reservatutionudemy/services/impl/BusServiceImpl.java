package com.builtlab.reservatutionudemy.services.impl;

import com.builtlab.reservatutionudemy.entities.Bus;
import com.builtlab.reservatutionudemy.repos.BusRepository;
import com.builtlab.reservatutionudemy.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
