package com.service.point.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.service.point.entity.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetHistoryRequest {
    @NotBlank
    private String place;
    @NotBlank
    private Status status;
}
