package com.example.videotecha.repository;

import com.example.videotecha.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT count(r.id) " +
            "FROM Reservation r " +
            "WHERE r.projection.id = :projection_id and r.user.id = :user_id ")
    int findNumberOfReservationsByUserIdAndProjectionId(@Param("projection_id") Long projectionId,
                                                        @Param("user_id") Long userId);

    List<Reservation> findAllByCanceledFalse();

}
