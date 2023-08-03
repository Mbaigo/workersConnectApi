package com.mbaigo.datecenter.workersConnect.workersconnectApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class ProviderDTO {
    private String title;
    private String description;
    private String email;
    private  String location;
    private String phoneNumber;
}
