package com.solvd.solvdmaven.interfaces;

import com.solvd.solvdmaven.exceptions.NegativeCostException;

public interface IPurchasable {
    void setPrice(float newPrice)  throws NegativeCostException;
    float getPrice();
}