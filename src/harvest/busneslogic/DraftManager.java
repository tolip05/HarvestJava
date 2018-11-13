package harvest.busneslogic;

import harvest.abstracts.Harvester;
import harvest.abstracts.Provider;
import harvest.abstracts.Unit;
import harvest.factores.HarvestFactory;
import harvest.factores.ProviderFactory;

import java.util.ArrayList;
import java.util.List;

public class DraftManager {
    private List<Harvester> harvesters;
    private List<Provider> providers;
    private HarvestFactory harvestFactory;
    private ProviderFactory providerFactory;
    private String mode;
    private double totalEnergyStored;
    private double totalMineOre;

    public DraftManager() {
        this.harvesters = new ArrayList<>();
        this.providers = new ArrayList<>();
        this.harvestFactory = new HarvestFactory();
        this.providerFactory = new ProviderFactory();
        this.mode = "Full";
        this.totalEnergyStored = 0;
        this.totalMineOre = 0;
    }
    public String registerHarvester(List<String>arguments){
        try{
            Harvester harvester = this.harvestFactory.createHarvest(arguments);

            this.harvesters.add(harvester);

            return String.format("Successfully registered %s Harvester - %s",harvester.getType(),harvester.getId());
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
    public String registerProvider(List<String>arguments){
        try{
            Provider provider = this.providerFactory.createProvider(arguments);
            this.providers.add(provider);
            return String.format("Successfully registered %s Provider - %s",provider.getType(),provider.getId());
        }catch (IllegalArgumentException e){

            return e.getMessage();
        }
    }
    public String mode(List<String>arguments){
        this.mode = arguments.get(0);
        return String.format("Successfully changed working mode to %s Mode",this.mode);
    }
    public String check(List<String>arguments){
        String id = arguments.get(0);
        Unit unit = null;
        for (Harvester harvester : harvesters) {
            if (harvester.getId().equals(id)){
                unit = harvester;
                break;
            }
        }
        if (unit == null){
            for (Provider provider : providers) {
                if (provider.getId().equals(id)){
                    unit = provider;
                    break;
                }
            }
        }
        if (unit != null){
            return unit.toString();
        }else {
            return String.format("No element found with id - %s.", id);
        }
    }
    public String day(){
        double dayEnergyProvider = 0;
        for (Provider provider : providers) {
            dayEnergyProvider += provider.getEnergyOutput();
        }
        this.totalEnergyStored += dayEnergyProvider;
        double dayEnergyRequaerd = 0D;
        double dayMineOre = 0D;
        if (mode.equals("Full")){
            for (Harvester harvester : harvesters) {
                dayEnergyRequaerd += harvester.getEnergyRequerement();
                 dayMineOre += harvester.getOreOutput();
            }

        }
        else if (mode.equals("Half")){
            for (Harvester harvester : harvesters) {
                dayEnergyRequaerd += harvester.getEnergyRequerement();
                dayMineOre += harvester.getOreOutput();
            }
            dayEnergyRequaerd = dayEnergyRequaerd * 0.6;
            dayMineOre += dayMineOre * 0.5;
        }
        else{
            dayEnergyRequaerd = 0;
            dayMineOre = 0;
        }
        if (totalEnergyStored > dayEnergyProvider){
            totalMineOre += dayMineOre;
            totalEnergyStored -= dayEnergyRequaerd;
        }
        return "A day has passed./n"+
                String.format("Energy Provided: %.2f/n",dayEnergyProvider)+
                String.format("Olumbus Ore Mined: %.2f",dayMineOre);
    }

    public String shutDown(){
        return "System ShutDown/n" +
                String.format("Total Energy Stored: %.2f/n",totalEnergyStored) +
                String.format("Total Mined Flumbus: %.2f",totalMineOre);
    }
}
