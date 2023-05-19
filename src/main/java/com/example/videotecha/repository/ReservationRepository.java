package com.example.videotecha.repository;

import com.example.videotecha.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    int countByUserIdAndProjectionId(@Param("user_id") Long userId, @Param("projection_id") Long projectionId);

    List<Reservation> findAllByCanceledFalse();

}
