package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.ServiceTypes;
import com.solvd.solvdmaven.interfaces.IFuncForLambdas;

import java.util.concurrent.atomic.AtomicReference;

public class PlaceOfService {
    protected ServiceTypes type;
    private AtomicReference<ServiceTypes> ourAtom;
    private IFuncForLambdas<ServiceTypes> setWithAtom;

    public PlaceOfService() {
        //
        type = ServiceTypes.OTHER;
        ourAtom = new AtomicReference<>();
        setWithAtom = (newType) -> {ourAtom.set(newType);};
    }

    public ServiceTypes getTypeOfService() {return type;}

    public void setTypeOfService(ServiceTypes theNewType) {
        setWithAtom.setValue(theNewType);
        this.type = ourAtom.get();
    }
}
