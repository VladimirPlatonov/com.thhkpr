package com.thhkpr.response;

import com.thhkpr.models.ThingsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class ProductListResponse {
    Collection<ThingsModel> products;
}
