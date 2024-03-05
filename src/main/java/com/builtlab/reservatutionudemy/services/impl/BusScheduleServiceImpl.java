package com.builtlab.reservatutionudemy.services.impl;

import com.builtlab.reservatutionudemy.entities.BusRoute;
import com.builtlab.reservatutionudemy.entities.BusSchedule;
import com.builtlab.reservatutionudemy.models.ReservationAPIException;
import com.builtlab.reservatutionudemy.repos.BusRouteRepository;
import com.builtlab.reservatutionudemy.repos.BusScheduleRepository;
import com.builtlab.reservatutionudemy.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;
    @Autowired
    private BusRouteRepository busRouteRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationAPIException{
        final boolean exists = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(),
                busSchedule.getBusRoute(),
                busSchedule.getDepartureTime());

        if (exists) {
            throw new ReservationAPIException(HttpStatus.CONTINUE, "Duplicate Schedule");
        }

        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getSchedulesByRoute(String routeName) {
        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName).orElseThrow(()-> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Not Found!"));
        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Not Found!"));
    }
}
