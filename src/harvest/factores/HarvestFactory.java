package harvest.factores;

import harvest.abstracts.Harvester;
import harvest.harvesters.HammerHarvester;
import harvest.harvesters.SonicHarvester;

import java.util.List;

public class HarvestFactory {

    public Harvester createHarvest(List<String> arguments){
        String type = arguments.get(0);
        type = type.toLowerCase();
        String id = arguments.get(1);
        double oreOutput = Double.parseDouble(arguments.get(2));
        double energyRequarement = Double.parseDouble(arguments.get(3));

        switch (type){
            case "hammer":
                return new HammerHarvester(id,oreOutput,energyRequarement);
            case "sonic":
                return new SonicHarvester(id,oreOutput,energyRequarement,Integer.parseInt(arguments.get(4)));
        default:
            throw new IllegalArgumentException("Invalid Harvest");
        }
    }
}
