package harvest.abstracts;

public abstract class Harvester extends Unit{
    private double oreOutput;
    private double energyRequerement;

    public Harvester(String id,double oreOutput,double energyRequaerment) {
        super(id);
        this.setOreOutput(oreOutput);
        this.setEnergyRequerement(energyRequaerment);
    }

    public double getOreOutput() {
        return this.oreOutput;
    }

    private void setOreOutput(double oreOutput) {
        if (oreOutput < 0){
            throw new IllegalArgumentException("Harvester is not registered,because of is't oreOutput");
        }
        this.oreOutput = oreOutput;
    }

    public double getEnergyRequerement() {
        return this.energyRequerement;
    }

    protected void setEnergyRequerement(double energyRequerement) {
        if (energyRequerement < 0 || energyRequerement > 20000){
            throw new IllegalArgumentException("Harvester is not registered,because of is't energyRequerement");
        }
        this.energyRequerement = energyRequerement;
    }

    @Override
    public String toString() {
        return String.format("%s Harvester - %s/n",this.getType(),this.getId())
        + String.format("Ore Output: %.2f/n",this.getOreOutput()) +
                String.format("Energy Requirement: %.2f",this.getEnergyRequerement());
    }
}
