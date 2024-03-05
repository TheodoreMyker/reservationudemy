package com.builtlab.reservatutionudemy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;
    @Column(name = "bus_name")
    private String busName;
    @Column(name = "bus_type")
    private String busType;
    @Column(name = "total_seat")
    private Integer totalSeat;
    @Column(name = "bus_number", unique = true)
    private String busNumber;


}
