package com.example.firstAPI.dto.request;

import com.example.firstAPI.DEnum.ECity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CitytValidator implements ConstraintValidator<CitySubset, ECity> {
    private ECity[] citys;
    @Override
    public void initialize(CitySubset constraintAnnotation) {
        this.citys = constraintAnnotation.anyOf();
        if (this.citys != null) {
            System.out.println("Cities: " + Arrays.toString(this.citys)); // Nếu citys là mảng
        }
        // Hoặc nếu citys là List
        else  {
            System.out.println("Cities: " + this.citys); // List sẽ tự động gọi toString() của mình
        }
    }

    @Override
    public boolean isValid(ECity value, ConstraintValidatorContext var2){
        return value == null || Arrays.asList(citys).contains(value);
    }
}
