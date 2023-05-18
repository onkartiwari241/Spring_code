package com.lcwd.electronic.store.ElectronicStore.controller;


import com.lcwd.electronic.store.ElectronicStore.dtos.ApiResponseMessage;
import com.lcwd.electronic.store.ElectronicStore.dtos.ImageResponse;
import com.lcwd.electronic.store.ElectronicStore.dtos.PagableResponse;
import com.lcwd.electronic.store.ElectronicStore.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore.services.FileService;
import com.lcwd.electronic.store.ElectronicStore.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Value("${user.profile.image.path}")
    private String imageUploadPath;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto user = userService.createUser(userDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable String id,@RequestBody UserDto userDto)
    {
        UserDto userDto1 = userService.updateUser(userDto, id);

        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String id) throws IOException {
        userService.deleteuser(id);

        ApiResponseMessage message = ApiResponseMessage.builder().message("User deleted successfully...").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public ResponseEntity<PagableResponse<UserDto>> getAllUsers(
            @RequestParam(value = "pageNumber",defaultValue = "10", required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "0", required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir)
            {
        return new ResponseEntity<>(userService.getAllUser(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable  String id)
    {
        return new ResponseEntity<>(userService.getuserById(id),HttpStatus.OK);
    }

    @GetMapping("/userByEmail/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable  String email)
    {
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDto>> searchUser(@PathVariable  String keywords)
    {
        return new ResponseEntity<>(userService.searchUser(keywords),HttpStatus.OK);
    }

    // upload user image

    @PostMapping("/image/{id}")
    public ResponseEntity<ImageResponse> uploadUserImage(@PathVariable String id,@RequestParam("userImage")MultipartFile image) throws IOException {
        String imageName = fileService.uploadImage(image, imageUploadPath);

        UserDto userDto = userService.getuserById(id);

        userDto.setImage(imageName);

        userService.updateUser(userDto,id);

        ImageResponse imageResponse = ImageResponse.builder().imageName(imageName).success(true).status(HttpStatus.CREATED).build();

        return new ResponseEntity<>(imageResponse,HttpStatus.CREATED);
    }

    // serve user image
    @GetMapping("/imagedownload/{id}")
    public void serveUserImage(@PathVariable String id, HttpServletResponse response) throws IOException {

        UserDto userDto = userService.getuserById(id);

        logger.info("User image name : {} "+userDto.getImage());

        InputStream resource = fileService.getResource(imageUploadPath, userDto.getImage());

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);

        StreamUtils.copy(resource,response.getOutputStream());
    }
}
