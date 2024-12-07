package com.teamai.hackitall.instorepicking;

public class RaionSector {
    private int raion;
    private int sector;

    public RaionSector(int raion, int sector) {
        this.raion = raion;
        this.sector = sector;
    }

    public int getRaion() {
        return raion;
    }

    public int getSector() {
        return sector;
    }

    public void setRaion(int raion) {
        this.raion = raion;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }
}
