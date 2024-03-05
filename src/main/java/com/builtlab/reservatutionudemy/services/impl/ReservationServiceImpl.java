package com.builtlab.reservatutionudemy.services.impl;

import com.builtlab.reservatutionudemy.entities.BusSchedule;
import com.builtlab.reservatutionudemy.entities.Customer;
import com.builtlab.reservatutionudemy.entities.Reservation;
import com.builtlab.reservatutionudemy.models.ReservationAPIException;
import com.builtlab.reservatutionudemy.models.ResponseModel;
import com.builtlab.reservatutionudemy.repos.BusScheduleRepository;
import com.builtlab.reservatutionudemy.repos.CustomerRepository;
import com.builtlab.reservatutionudemy.repos.ReservationRepository;
import com.builtlab.reservatutionudemy.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BusScheduleRepository busScheduleRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        final Customer customer;
        final boolean doesCustomerExist = customerRepository.existsByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail());
        if(doesCustomerExist) {
            customer = customerRepository.findByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail()).orElseThrow();
        }else {
            customer = customerRepository.save(reservation.getCustomer());
        }
        reservation.setCustomer(customer);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate) {
        final BusSchedule schedule = busScheduleRepository.findById(scheduleId).orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Schedule not found"));
        return reservationRepository.findByBusScheduleAndDepartureDate(schedule, departureDate).orElseThrow(()-> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Reservation not found"));
    }

    @Override
    public List<Reservation> getReservationsByMobile(String mobile) {
        final Customer customer = customerRepository.findByMobile(mobile).orElseThrow(()-> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No record found"));
        return reservationRepository.findByCustomer(customer).orElseThrow(()-> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No record found"));
    }
}
