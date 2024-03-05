package com.builtlab.reservatutionudemy.services;

import com.builtlab.reservatutionudemy.entities.Bus;

import java.util.List;

public interface BusService {
   Bus addBus(Bus bus);
   List<Bus> getAllBus();

}
