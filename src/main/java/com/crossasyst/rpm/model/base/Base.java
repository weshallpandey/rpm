package com.crossasyst.rpm.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    private LocalDateTime createdTs;

    @CreatedBy
    private Long createdBy;

    private LocalDateTime updatedTs;


    private Long updatedBy;
}
