package com.cheaclo.clothesdatabase.service.response;

import com.cheaclo.clothesdatabase.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CategoryByShopResponse {
    public ProductType type;
    public List<CategoryResponse> categories;
}
