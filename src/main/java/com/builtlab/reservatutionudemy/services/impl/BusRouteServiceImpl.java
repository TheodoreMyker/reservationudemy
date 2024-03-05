package com.builtlab.reservatutionudemy.services.impl;

import com.builtlab.reservatutionudemy.entities.BusRoute;
import com.builtlab.reservatutionudemy.models.GlobalExceptionHandler;
import com.builtlab.reservatutionudemy.models.ReservationAPIException;
import com.builtlab.reservatutionudemy.repos.BusRouteRepository;
import com.builtlab.reservatutionudemy.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Autowired
    private BusRouteRepository busRouteRepository;
    @Override
    public BusRoute addRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No such route found!"));
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom, cityTo).orElseThrow(()-> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No such route found!"));
    }
}
