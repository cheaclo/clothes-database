package com.cheaclo.clothesdatabase.service.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    public String name;
    public boolean available;
}
