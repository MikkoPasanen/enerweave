package enerweave.backend.service;

import enerweave.backend.entity.HEMS;
import enerweave.backend.entity.Hardware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ControllerService {

    public List<Hardware> addHardwares() {
        String[] models = {"MT681", "XT900", "SG500", "BT100", "LT300", "MT68145", "MT68sdfgfsd1", "MT68dfhgdf1", "MT352681", "MT6gfd81","MT6815151"};
        String[] types = {"Energy Meter", "Smart Sensor", "Thermostat", "Light Controller", "Battery"};
        String[] manufacturers = {"Samsung", "Bosch", "Mitsubishi", "Vaillant", "Stiebel"};

        List<Hardware> hardwareList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i <= 12; i++) {
            String model = models[random.nextInt(models.length)];
            String type = types[random.nextInt(types.length)];
            String manufacturer = manufacturers[random.nextInt(manufacturers.length)];

            Hardware hardware = new Hardware();
            hardwareList.add(hardware);
        }

        Collections.shuffle(hardwareList);
        return hardwareList.subList(0, 4);
    }

    public List<HEMS> generateListOfHEMS() {
        String[] names = {"Kiwigrid", "Loxone", "Clever PV", "Solarmanager", "Consolinno"};
        String[] producers = {"A", "B", "C", "D", "E"};

        List<HEMS> differentHEMS = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i <= 5; i++) {
            String name = names[random.nextInt(names.length)];
            String producer = producers[random.nextInt(producers.length)];

            HEMS hems = new HEMS();
            differentHEMS.add(hems);
        }

        return differentHEMS;
    }
}
