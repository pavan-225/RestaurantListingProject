package com.thbs.repository;

import com.thbs.model.BookingDetails;
import com.thbs.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

/**
 *
 * @author Priyanka_Ramesh
 *
 */

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurants, Integer> {

    @Query("SELECT r FROM Restaurants r")
    List<Blob> findImages();

}
