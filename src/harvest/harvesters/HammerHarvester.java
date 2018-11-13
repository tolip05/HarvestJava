package harvest.harvesters;

import harvest.abstracts.Harvester;

public class HammerHarvester extends Harvester {


    public HammerHarvester(String id, double oreOutput, double energyRequaerment) {
        super(id, oreOutput * 3, energyRequaerment * 2);
    }

    @Override
    public String getType() {
        return "Hammer";
    }
}
