package swag.qrorder.service;

import swag.qrorder.model.Seat;

import java.util.List;

public interface SeatService {
    boolean addSeat(String restaurantId, int count);
    boolean updateSeat(Seat seat);
    boolean deleteSeat(List<Integer> seatIds);
}
