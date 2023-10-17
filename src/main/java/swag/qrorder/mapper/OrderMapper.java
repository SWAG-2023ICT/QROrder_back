package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Order;
import swag.qrorder.model.OrderDetail;

import java.util.List;

@Mapper
public interface OrderMapper {
    Integer addOrder(Order order);
    Integer addOrderList(List<OrderDetail> orderDetails);
    Integer addSelectedOption(List<OrderDetail> orderDetails);
}
