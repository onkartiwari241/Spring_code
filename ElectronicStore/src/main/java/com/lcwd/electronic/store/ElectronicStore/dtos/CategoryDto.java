package com.lcwd.electronic.store.ElectronicStore.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryDto {
    private String categoriId;
    @NotBlank(message = "Tittle is required")
    private String tittle;
    @NotBlank(message = "Description is required....")
    private String description;
    private String coverImage;
}