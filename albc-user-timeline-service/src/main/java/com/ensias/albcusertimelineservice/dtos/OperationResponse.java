package com.ensias.albcusertimelineservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse {

    int status;
    String error;
    String message;
    String path;
}