package com.lcwd.electronic.store.ElectronicStore.controller;

import com.lcwd.electronic.store.ElectronicStore.dtos.*;
import com.lcwd.electronic.store.ElectronicStore.services.FileService;
import com.lcwd.electronic.store.ElectronicStore.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
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

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private FileService fileService;

    @Value("${product.image.path}")
    private String imagePath;

    @Autowired
    private ProductService productService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    // create
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
    {
        ProductDto savedProduct = productService.create(productDto);
        return ResponseEntity.ok(savedProduct);
    }

    // update
    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable String productId)
    {
        ProductDto updateProduct = productService.update(productDto, productId);
        return ResponseEntity.ok(updateProduct);
    }

    // delete
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponseMessage> deleteProduct(@PathVariable String productId) throws IOException {
        productService.delete(productId);
        ApiResponseMessage response = ApiResponseMessage.builder().message("Product is deleted successfully !!").status(HttpStatus.OK).success(true).build();

        return ResponseEntity.ok(response);
    }

    // get by producId
    @GetMapping("/productById/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String productId)
    {
        ProductDto productDto = productService.productById(productId);
        return ResponseEntity.ok(productDto);
    }

    // get all products
    @GetMapping("/allProducts")
    public ResponseEntity<PagableResponse<ProductDto>> getAllProducts(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "tittle",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
            ){
        PagableResponse<ProductDto> productDtoPagableResponse = productService.allProducts(pageNumber, pageSize, sortBy, sortDir);

        return ResponseEntity.ok(productDtoPagableResponse);
    }

    // get all live
    @GetMapping("/allLiveProducts")
    public ResponseEntity<PagableResponse<ProductDto>> getAllLiiceProducts(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "tittle",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir

    ){
        PagableResponse<ProductDto> allLive = productService.getAllLive(pageNumber, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(allLive,HttpStatus.OK);
    }

    // search by tittle
    @GetMapping("/search/{keyword}")
    public ResponseEntity<PagableResponse<ProductDto>> searchByKeyword(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "tittle",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir,
            @PathVariable String keyword

    ){
        PagableResponse<ProductDto> productDtoPagableResponse = productService.searchByTittle(keyword, pageNumber, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(productDtoPagableResponse,HttpStatus.OK);
    }

    // upload image
    @PostMapping("/imageUpload/{productId}")
    public ResponseEntity<ImageResponse> uploadProductImage(@PathVariable String productId, @RequestParam("productImage")MultipartFile productImage) throws IOException {

        String fileName = fileService.uploadImage(productImage, imagePath);
        ProductDto productDto = productService.productById(productId);

        productDto.setProductImageName(fileName);
        ProductDto updatedProduct = productService.update(productDto, productId);

        ImageResponse response = ImageResponse.builder().imageName(updatedProduct.getProductImageName()).message("Product image is successfully uploaded...").status(HttpStatus.CREATED).success(true).build();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    // download image
    @GetMapping("/imagedownload/{productId}")
    public void serveUserImage(@PathVariable String productId, HttpServletResponse response) throws IOException {

        ProductDto productDto = productService.productById(productId);

        logger.info("User image name : {} "+productDto.getProductImageName());

        InputStream resource = fileService.getResource(imagePath, productDto.getProductImageName());

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);

        StreamUtils.copy(resource,response.getOutputStream());
    }
}
