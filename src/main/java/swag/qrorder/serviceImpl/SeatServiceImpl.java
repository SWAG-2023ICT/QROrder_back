package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.common.util.RandomCodeUtil;
import swag.qrorder.mapper.SeatMapper;
import swag.qrorder.model.Seat;
import swag.qrorder.service.SeatService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {
    private final SeatMapper seatMapper;
    private final RandomCodeUtil randomCodeUtil;
    @Override
    public boolean addSeat(String restaurantId, int count) {
        List<Seat> seats = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            seats.add(Seat.builder()
                    .seatName(sb.append(i+1).append("번 좌석").toString())
                    .restaurantId(restaurantId)
                    .qrKey(randomCodeUtil.createRandomCode(32))
                    .build());
            sb.delete(0,sb.length());
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
    public boolean deleteSeat(List<Integer> seatIds) {
        Integer result = seatMapper.deleteSeat(seatIds);
        return result > 0;
    }
}
