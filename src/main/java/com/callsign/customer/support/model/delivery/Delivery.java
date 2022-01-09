package com.callsign.customer.support.model.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deliveryId;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private Timestamp expectedDeliveryTime;
    @Column(name = "current_distance_from_destination_in_meters")
    private int distanceFromDestination;
    private Timestamp timeToReachDestination;
    private int riderRating;
    @Column(name = "restaurant_mean_time_to_prepare_food")
    private Timestamp timeToPrepareFood;
}
