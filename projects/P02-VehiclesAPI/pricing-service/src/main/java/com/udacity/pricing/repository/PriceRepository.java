package com.udacity.pricing.repository;

import com.udacity.pricing.entity.Price;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends PagingAndSortingRepository<Price,Long> {
        Price findByVehicleId(Long vehicleId);
}
