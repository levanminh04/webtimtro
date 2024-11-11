package com.example.WebTimTroBA.Controller;

import com.example.WebTimTroBA.CustomException.NotNullException;
import com.example.WebTimTroBA.Model.DTO.MotelDTO;
import com.example.WebTimTroBA.Model.DTO.UserDTO;
import com.example.WebTimTroBA.Model.DTO.UserLoginDTO;
import com.example.WebTimTroBA.Model.Response.MotelResponse;
import com.example.WebTimTroBA.Model.Search.MotelSearchBuilder;
import com.example.WebTimTroBA.Service.MotelService;
import com.example.WebTimTroBA.Service.UserService;
import com.example.WebTimTroBA.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    private final MotelService motelService;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @GetMapping("/")
    public ResponseEntity<Object>searchByMotelSearchBuilder(MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));
    }
    @GetMapping( value = "/dashboard")
    public ResponseEntity<?> getAll() throws MalformedURLException {
        List<MotelResponse> motelResponses = motelService.findAll();
        return ResponseEntity.ok().body(motelResponses);
    }
    @GetMapping("/get-infor")
    public ResponseEntity<?> getUserDetail(@RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return ResponseEntity.ok(userService.getUserDetail(token));
    }
    @PostMapping("/create")
    public ResponseEntity<?> addMotel(MotelDTO motelDTO, @RequestHeader("Authorization") String authorization) throws IOException {

        try{
            String token = authorization.replace("Bearer ", "");
            motelService.save(motelDTO, token);
            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value="/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            userService.createUser(userDTO);
            return ResponseEntity.accepted().body("Success");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value="/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userDTO){
        try{
            String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
            return ResponseEntity.ok(token);
        }
        catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("{userName}/added-buildings")
    @PreAuthorize("#userName == authentication.name")
    public ResponseEntity<?> searchByUserId(@PathVariable("userName") String userName, @RequestHeader("authorization") String token) {
        if(userName == null) throw new NotNullException("User not exist");
        if(jwtTokenUtils.isTokenUserNameValid(token.substring(7), userName)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        try{
            return ResponseEntity.ok().body(motelService.findByUserName(userName));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMotel(@PathVariable("id") Integer id){
        motelService.deleteById(id);
        return ResponseEntity.ok().body("Success");
    }

}
