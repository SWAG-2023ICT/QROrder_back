package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Item;
import swag.qrorder.model.Restaurant;
import swag.qrorder.model.Session;
import swag.qrorder.service.UserService;
import swag.qrorder.vo.ItemVo;
import swag.qrorder.vo.OrderVo;

import java.util.List;

@Slf4j
@RequestMapping(value = "/qrorder/menus",produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/{qrKey}")
    public ResponseEntity<?> findMenuByQr(@PathVariable String qrKey){
        Restaurant restaurant = userService.findMenuByQr(qrKey);
        if(restaurant.getItems().isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");

        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> findMenuDetail(@RequestParam int itemId){
        Item item = userService.getMenuDetail(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @PostMapping("/{qrKey}/order")
    public ResponseEntity<?> addOrder(@PathVariable String qrKey, @RequestBody OrderVo orderVo){
        Session session = userService.addOrder(qrKey,orderVo);
        if(session != null) return ResponseEntity.ok(session);

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/history/{sessionId}")
    public ResponseEntity<?> findHistory(@PathVariable String sessionId){
        List<OrderVo> orders = userService.findHistory(sessionId);
        if(orders != null) return ResponseEntity.ok(orders);

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/history/detail")
    public ResponseEntity<?> findHistoryDetail(@RequestParam int orderListId){
        List<ItemVo> items = userService.findHistoryDetail(orderListId);
        if(items != null) return ResponseEntity.ok(items);

        return ResponseEntity.badRequest().build();
    }



}
