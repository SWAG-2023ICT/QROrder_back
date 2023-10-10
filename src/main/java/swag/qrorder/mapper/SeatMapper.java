package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Seat;

import java.util.List;

@Mapper
public interface SeatMapper {
    Seat findSeatByQr(String qrKey);
    Integer addSeat(List<Seat> seats);
    Integer updateSeat(Seat seat);
    Integer deleteSeat(String seatId);
}
