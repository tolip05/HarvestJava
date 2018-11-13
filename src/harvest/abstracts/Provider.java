package harvest.abstracts;

public abstract class Provider extends Unit {

    private double energyOutput;

    public Provider(String id,double energyOutput) {
        super(id);
        this.setEnergyOutput(energyOutput);
    }

    public double getEnergyOutput() {
        return this.energyOutput;
    }

    private void setEnergyOutput(double energyOutput) {
        if (energyOutput < 0 || energyOutput > 10000){
            throw new IllegalArgumentException("Provider is not registered,because of is't energyOutput");
        }
        this.energyOutput = energyOutput;
    }

    @Override
    public String toString() {

        return String.format("%s Provider - %s/n",this.getType(),super.getId()) +
        String.format("Energy Output: %.2f",this.getEnergyOutput());
    }
}
