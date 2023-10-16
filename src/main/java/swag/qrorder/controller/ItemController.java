package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import swag.qrorder.model.Item;
import swag.qrorder.model.Option;
import swag.qrorder.service.ItemService;

import java.io.IOException;
import java.util.List;

@RequestMapping(value="/qrorder/items",produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/{itemId}")
    public ResponseEntity<?> addItemDetail(@PathVariable int itemId,@RequestBody List<Integer> categoryIds){
        boolean flag = itemService.addItemDetails(itemId,categoryIds);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PostMapping(value = "",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addItems(@RequestPart MultipartFile itemImage,
                                      @RequestPart Item item) throws IOException {
        item.setItemImage(itemImage.getBytes());
        boolean flag = itemService.addItems(item);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PutMapping(value = "",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateItems(@RequestPart MultipartFile itemImage,
                                         @RequestPart Item item) throws IOException {
        item.setItemImage(itemImage.getBytes());
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
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getCategories());
    }
    @PostMapping("/options")
    public ResponseEntity<?> addOptions(@RequestBody List<Option> option){
        boolean flag = itemService.addOptions(option);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
}