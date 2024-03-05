package com.builtlab.reservatutionudemy.repos;

import com.builtlab.reservatutionudemy.entities.BusSchedule;
import com.builtlab.reservatutionudemy.entities.Customer;
import com.builtlab.reservatutionudemy.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<List<Reservation>> findByCustomer(Customer customer);
    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate);
}