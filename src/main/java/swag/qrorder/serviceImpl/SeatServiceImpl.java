package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.SeatMapper;
import swag.qrorder.model.Seat;
import swag.qrorder.service.SeatService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {
    private final SeatMapper seatMapper;
    @Override
    public boolean addSeat(String restaurantId, int count) {
        List<Seat> seats = new ArrayList<>();
        for(int i = 0; i < count; i++){
            seats.add(Seat.builder()
                    .seatName(String.valueOf(i+1))
                    .restaurantId("341-52-93011") // restaurantId
                    .qrKey("random key")
                    .build());
        }
        Integer result = seatMapper.addSeat(seats);
        return result == count;
    }
    @Override
    public boolean updateSeat(Seat seat) {
        Integer result = seatMapper.updateSeat(seat);
        return result > 0;
    }
    @Override
    public boolean deleteSeat(String seatId) {
        Integer result = seatMapper.deleteSeat(seatId);
        return result > 0;
    }
}
