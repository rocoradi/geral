package br.com.hcode.designpattern.factory.vehicles;

import br.com.hcode.designpattern.factory.Transport;

public class BikeTransportMinha extends Transport {
    @Override
    protected IVehicle createTransport() {
        return new BikeMinha();
    }
}
