package com.builtlab.reservatutionudemy.repos;

import com.builtlab.reservatutionudemy.entities.Bus;
import com.builtlab.reservatutionudemy.entities.BusRoute;
import com.builtlab.reservatutionudemy.entities.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);
    Boolean existsByBusAndBusRouteAndDepartureTime(Bus bus, BusRoute busRoute, String date);
}