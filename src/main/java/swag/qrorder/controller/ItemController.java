package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Item;
import swag.qrorder.service.ItemService;

import java.util.List;

@RequestMapping("/qrorder/items")
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;
    @PostMapping("")
    public ResponseEntity<?> addItems(@RequestBody List<Item> items){
        boolean flag = itemService.addItems(items);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PutMapping("")
    public ResponseEntity<?> updateItems(@RequestBody Item item){
        boolean flag = itemService.updateItem(item);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PutMapping("/{itemId}")
    public ResponseEntity<?> updateItemStatus(@PathVariable int itemId){
        boolean flag = itemService.updateItemStatus(itemId);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable int itemId){
        boolean flag = itemService.deleteItem(itemId);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
}