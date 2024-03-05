package com.builtlab.reservatutionudemy.repos;

import com.builtlab.reservatutionudemy.entities.Bus;
import com.builtlab.reservatutionudemy.entities.BusRoute;
import com.builtlab.reservatutionudemy.services.BusService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus,Long> {


}
