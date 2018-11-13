package harvest.harvesters;

import harvest.abstracts.Harvester;

public class SonicHarvester extends Harvester {

    private int sonicFactor;
    public SonicHarvester(String id, double oreOutput, double energyRequaerment,int sonicFactor) {
        super(id, oreOutput, energyRequaerment);
        this.sonicFactor = sonicFactor;
        super.setEnergyRequerement(super.getEnergyRequerement() / this.sonicFactor);
    }

    public int getSonicFactor() {
        return this.sonicFactor;
    }

    @Override
    public String getType() {
        return "Sonic";
    }
}
