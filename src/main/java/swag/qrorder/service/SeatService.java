package swag.qrorder.service;

import swag.qrorder.model.Seat;

public interface SeatService {
    boolean addSeat(String restaurantId, int count);
    boolean updateSeat(Seat seat);
    boolean deleteSeat(String seatId);
}
