package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.ServiceTypes;

public class PlaceOfService {
    protected ServiceTypes type;

    public PlaceOfService() {
        type = ServiceTypes.OTHER;
    }

    public ServiceTypes getTypeOfService() {return type;}
}
